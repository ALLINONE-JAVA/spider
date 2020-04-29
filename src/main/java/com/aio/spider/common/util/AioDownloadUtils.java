package com.aio.spider.common.util;

import org.springframework.util.Assert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/** 文件下载工具类
 * @author ChenHao
 * @title: AioDownloadUtils
 * @date 2020-04-29 13:21
 */
public class AioDownloadUtils {

    public static boolean download(String filePath ,String fileName ,String url){
        Assert.notNull(filePath,"保存路径不能为空");
        Assert.notNull(fileName,"文件名称不能为空");
        Assert.notNull(url,"资源地址不能为空");
        URL url1 = null;
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            url1 = new URL(url);
            inputStream = url1.openConnection().getInputStream();
            byte[] bs = new byte[1024];
            int len;
            File file = new File(filePath + fileName);
            outputStream = new FileOutputStream(file,true);
            while ((len=inputStream.read(bs))!=-1){
                outputStream.write(bs,0,len);
            }
        } catch (MalformedURLException e) {
            LogUtil.error(AioDownloadUtils.class,"文件下载失败",e);
            return false;
        } catch (IOException e) {
            LogUtil.error(AioDownloadUtils.class,"文件下载失败",e);
            return false;
        }finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }


}
