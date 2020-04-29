package com.aio.spider.common.config.spider;

import com.aio.spider.common.config.constant.DaoJiaLeSpiderConstants;
import com.aio.spider.common.config.constant.SpiderConstants;
import com.aio.spider.common.emun.SpiderTypeEnum;
import com.aio.spider.common.util.AioStringUtils;
import com.aio.spider.common.util.MatcherUtils;
import com.aio.spider.core.dto.in.DaoJiaLeHouseDto;
import com.aio.spider.common.util.LogUtil;
import com.aio.spider.core.dto.in.DaoJiaLeHouseResourceDto;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
import java.util.stream.Collectors;

/** 到家了房源爬虫页面处理器
 * @author ChenHao
 * @title: DaoJiaLePageProcessorImpl
 * @date 2020-04-28 10:29
 */
public class DaoJiaLeHousePageProcessorImpl implements PageProcessor {


    // 设置抓取参数
    private Site site = Site.me()
            .setDomain("daojiale.com")
            .setCharset("UTF-8")
            .setSleepTime(5000)
            .setTimeOut(3000)
            .setRetryTimes(5)
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    @Override
    public void process(Page page) {
        Selectable url = page.getUrl();
        LogUtil.debug(getClass(),"houseUrl开始爬取！",url);
        if(url.toString().endsWith(".html")){
            //详情页数据抓取（视频图片的下载）
            Html html = page.getHtml();
            List<String> lis = html.$("ul.swiper-wrapper li").all();
            List<DaoJiaLeHouseResourceDto> daoJiaLeHouseResourceDtoList = lis.stream().map(e -> DaoJiaLeHouseResourceDto(e)).filter(e -> e != null).collect(Collectors.toList());
            // 设置数据
            page.putField(SpiderConstants.SPIDER_TYPE_KEY,SpiderTypeEnum.ESF_DOWNLOAD);
            page.putField(SpiderConstants.SPIDER_DATA_KEY, daoJiaLeHouseResourceDtoList);
        }else{
            // 列表json格式数据抓取
            JSONObject jsonObject = JSON.parseObject(page.getRawText());
            JSONArray dataRows = (JSONArray) JSONPath.eval(jsonObject,"$.data.rows");
            if(dataRows != null ){
                List<DaoJiaLeHouseDto> daoJiaLeHouseDtoList = dataRows.stream().map(e -> {
                    DaoJiaLeHouseDto daoJiaLeHouseDto = JSONObject.toJavaObject((JSONObject) e, DaoJiaLeHouseDto.class);
                    return daoJiaLeHouseDto;
                }).filter(e -> e != null).collect(Collectors.toList());
                for (DaoJiaLeHouseDto daoJiaLeHouseDto : daoJiaLeHouseDtoList) {
                    addRequest(page, daoJiaLeHouseDto.getHouseid());
                }
                addPageRequest(page,url.toString());
                // 设置数据
                page.putField(SpiderConstants.SPIDER_TYPE_KEY, SpiderTypeEnum.ESF);
                page.putField(SpiderConstants.SPIDER_DATA_KEY, daoJiaLeHouseDtoList);
            }else {
                //忽略掉此次数据
                page.setSkip(true);
                LogUtil.info(getClass(),"爬取json数据出现错误，详情访问地址:"+url);
            }
        }

    }

    @Override
    public Site getSite() {
        return site;
    }

    // 追加下一页
    private static Page addPageRequest(Page page,String url){
        String[] split = url.toString().split("pageNo=");
        if(Long.valueOf(split[1]) == 5){
            // 只爬取4条数据
            return page;
        }
        page.addTargetRequest(split[0] + "pageNo=" + String.valueOf(Long.valueOf(split[1]) != null ? Long.valueOf(split[1])+1:1));
        return page;
    }

    // 爬取详情数据
    private static Page addRequest(Page page,Integer param){
        if(param == null){
            // 跳过当前数据
            return page;
        }
        String url = DaoJiaLeSpiderConstants.DAOJIALE_HOUE_DETAIL_URL.substring(0, DaoJiaLeSpiderConstants.DAOJIALE_HOUE_DETAIL_URL.lastIndexOf("/"))
               + "/" +param+".html";
        page.addTargetRequest(url);
        return page;
    }


    // 解析img标签
    private static DaoJiaLeHouseResourceDto DaoJiaLeHouseResourceDto(String source){
        DaoJiaLeHouseResourceDto daoJiaLeHouseResourceDto = new DaoJiaLeHouseResourceDto();
        daoJiaLeHouseResourceDto.setName(MatcherUtils.match(source,"img","tit"));
        daoJiaLeHouseResourceDto.setUrl(MatcherUtils.match(source,"img","src"));
        if(AioStringUtils.isEmpty(daoJiaLeHouseResourceDto.getUrl())){
            return null;
        }
        return daoJiaLeHouseResourceDto;
    }
    // 解析获取html属性值

}
