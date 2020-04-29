package com.aio.spider.common.util;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 正则操作
 * @author ChenHao
 * @title: MatcherUtils
 * @date 2020-04-29 12:40
 */
public class MatcherUtils {

    /***
    * @Description:  解析 Html标签中的属性值
    * @param source html文本
    * @param element HTML标签
    * @param attr 属性名称
    * @return: java.lang.String 属性最后一次的值
    * @Author: ChenHao
    * @date: 2020-04-29
    */
    public static String match(String source, String element, String attr) {
        Assert.notNull(source,"参数不能为空");
        Assert.notNull(element,"参数不能为空");
        Assert.notNull(attr,"参数不能为空");
        String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?\\s.*?>";
        Matcher m = Pattern.compile(reg).matcher(source);
        String result = null;
        while (m.find()) {
            result = m.group(1);
        }
        return result;
    }
}
