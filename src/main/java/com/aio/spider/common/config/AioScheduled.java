package com.aio.spider.common.config;

import com.aio.spider.common.config.constant.DaoJiaLeSpiderConstants;
import com.aio.spider.common.config.spider.DaoJiaLeHousePageProcessorImpl;
import com.aio.spider.core.service.impl.DaojiaLeHousePipelineImpl;
import com.aio.spider.common.util.LogUtil;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/** 定时调度任务
 * @author ChenHao
 * @title: AioScheduled
 * @date 2020-04-28 9:51
 */
@Component
@EnableScheduling
public class AioScheduled  {
    /** 爬虫线程数量 */
    public static final Integer THREAD_SIZE = 5;

    /**
    * @Description:
    * @return: void
    * @Author: ChenHao
    * @date: 2020-04-28
    */
    @Scheduled(cron = "0 05 22 ? * *")
    public void daoJiaLeHouseSpider(){
        LogUtil.info(getClass(),"到家了爬虫调度任务开始执行...");
        try {
           Spider spider = Spider.create(new DaoJiaLeHousePageProcessorImpl());
           spider.addUrl(DaoJiaLeSpiderConstants.DAOJIALE_HOUSE_ERSHOUFANG_SPIDER_BASE_URL,DaoJiaLeSpiderConstants.DAOJIALE_HOUSE_ZUFANG_SPIDER_BASE_URL,DaoJiaLeSpiderConstants.DAOJIALE_HOUE_DETAIL_URL)
                   .addPipeline(new DaojiaLeHousePipelineImpl())
                   .thread(THREAD_SIZE)
                   .setExitWhenComplete(true)
                   .start();
           // spider.stop();
        }catch (Exception e){
           LogUtil.error(getClass(),"到家了爬虫调度任务执行错误...",e);
        }
    }


}
