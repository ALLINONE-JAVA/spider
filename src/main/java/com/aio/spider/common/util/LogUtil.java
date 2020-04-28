package com.aio.spider.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 日志答应类
 * @author ChenHao
 * @title: LogUtil
 * @date 2020-04-27 18:28
 */
public class LogUtil {

    /***
    * @Description: 错误日志打印
    * @param clazz getclass() 获取操作类信息
    * @param message 打印语句
    * @param throwable 抛出的异常
    * @return: void
    * @Author: ChenHao
    * @date: 2020-04-27
    */
    public static final void error(Class<?> clazz, String message,Throwable throwable) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(message,throwable);
    }


    /**
    * @Description: 一般日志打印
    * @param clazz getclass() 获取操作类信息
    * @param message 打印语句
    * @return: void
    * @Author: ChenHao
    * @date: 2020-04-27
    */
    public static final void info(Class<?> clazz, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info(message);
    }


    /***
    * @Description: 调试日志打印
    * @param clazz getclass() 获取操作类信息
    * @param message 打印语句
    * @param objets
    * @return: void
    * @Author: ChenHao
    * @date: 2020-04-27
    */
    public static final void debug(Class<?> clazz, String message,Object ... objets) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.debug(message,objets);
    }
}
