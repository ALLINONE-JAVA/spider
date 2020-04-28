package com.aio.spider.core.service.impl;

import com.aio.spider.common.config.constant.SpiderConstants;
import com.aio.spider.common.emun.SpiderTypeEnum;
import com.aio.spider.core.dto.in.DaoJiaLeHouseDto;
import com.aio.spider.common.util.LogUtil;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/** 到家了房源爬虫处理类
 * @author ChenHao
 * @title: DaojiaLeHousePipelineImpl
 * @date 2020-04-28 10:42
 */
public class DaojiaLeHousePipelineImpl implements Pipeline {

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


    }
}
