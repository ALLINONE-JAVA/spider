package com.aio.spider.common.util;

import org.springframework.util.StringUtils;

/**
 * @description: TODO String工具栏
 * @author: Mr.chen
 * @date: 2020/3/27 11:55
 * @version: 1.0
 */
public class AioStringUtils {

    /***
     * @Description:  判断string是否为空
     */
    public static boolean isEmpty(String ... str){
        for (String s : str) {
            if(org.springframework.util.StringUtils.isEmpty(s)){
                return true;
            }
        }
        return false;
    }

    /***
     * @Description:  判断string是否为空
     */
    public static boolean isNotEmpty(String ... str){
        return !isEmpty(str);
    }
}
