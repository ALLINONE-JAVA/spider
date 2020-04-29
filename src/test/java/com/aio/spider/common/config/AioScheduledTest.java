package com.aio.spider.common.config;

import com.aio.spider.SpiderApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/** 爬虫测试
 * @author ChenHao
 * @title: AioScheduledTest
 * @date 2020-04-28 13:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpiderApplication.class})// 指定启动类
class AioScheduledTest {

    @Autowired
    private AioScheduled aioScheduled;

    @Test
    void daoJiaLeHouseSpider() {
        aioScheduled.daoJiaLeHouseSpider();
    }
}