package com.aio.spider.core.service.impl;

import com.aio.spider.common.config.constant.SpiderConstants;
import com.aio.spider.common.emun.SpiderTypeEnum;
import com.aio.spider.common.util.AioDownloadUtils;
import com.aio.spider.core.dto.in.DaoJiaLeHouseDto;
import com.aio.spider.common.util.LogUtil;
import com.aio.spider.core.dto.in.DaoJiaLeHouseResourceDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/** 到家了房源爬虫处理类
 * @author ChenHao
 * @title: DaojiaLeHousePipelineImpl
 * @date 2020-04-28 10:42
 */
@Service
public class DaojiaLeHousePipelineImpl implements Pipeline {

    @Value("${aio.downloadPath}")
    private String downloadPath;

    @Override
    public void process(ResultItems resultItems, Task task) {
        Object type = resultItems.get(SpiderConstants.SPIDER_TYPE_KEY);
        if(type == null){
            LogUtil.info(getClass(),"获取不到处理类型,爬虫已中断。");
            return;
        }
        if(SpiderTypeEnum.ESF.equals(type)){
            List<DaoJiaLeHouseDto> data = resultItems.get(SpiderConstants.SPIDER_DATA_KEY);
            if(data == null){
                LogUtil.info(getClass(),"二手房处理时,获取不到有效的数据,爬虫已中断。");
                return;
            }
            data.stream().forEach(e->System.out.println(e.toString()));
        }
        if(SpiderTypeEnum.ESF_DOWNLOAD.equals(type)){
            List<DaoJiaLeHouseResourceDto> data = resultItems.get(SpiderConstants.SPIDER_DATA_KEY);
            if(data == null){
                LogUtil.info(getClass(),"二手房图片下载,获取不到有效的数据,爬虫已中断。");
                return;
            }
            data.stream().forEach(e->{
                String[] split = e.getUrl().split("/");
                String path = downloadPath + split[split.length-2] + "/";
                String name = e.getName() + e.getUrl().substring(e.getUrl().lastIndexOf("."));
                AioDownloadUtils.download(path,name,e.getUrl());
            });
        }

    }
}
