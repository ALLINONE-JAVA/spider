package com.aio.spider.core.dto.in;

/** 到家了需要下载的资源实体
 * @author ChenHao
 * @title: DaoJiaLeHouseResourceDto
 * @date 2020-04-28 17:08
 */
public class DaoJiaLeHouseResourceDto {

    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
