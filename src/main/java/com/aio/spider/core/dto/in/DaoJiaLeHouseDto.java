package com.aio.spider.core.dto.in;

import java.io.Serializable;

/** 到家了房源实体
 * @author ChenHao
 * @title: DaoJiaLeHouse
 * @date 2020-04-28 11:31
 */
public class DaoJiaLeHouseDto implements Serializable {

    private Integer houseid;
    private String dealtype;
    private String housetitle;
    private String houseNo;
    private String areaname;
    private String districtname;
    private String dzname;
    private String dyname;
    private String fhname;
    private String buildname;
    private Integer streettop;
    private Integer fang;
    private Integer ting;
    private Integer wei;
    private Integer yangtai;
    private String ownerTel;//房源电话
    private Integer saletotal;//售价 万元
    private Integer zutotal;//租价 元


    public Integer getHouseid() {
        return houseid;
    }

    public void setHouseid(Integer houseid) {
        this.houseid = houseid;
    }

    public String getDealtype() {
        return dealtype;
    }

    public void setDealtype(String dealtype) {
        this.dealtype = dealtype;
    }

    public String getHousetitle() {
        return housetitle;
    }

    public void setHousetitle(String housetitle) {
        this.housetitle = housetitle;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

    public String getDzname() {
        return dzname;
    }

    public void setDzname(String dzname) {
        this.dzname = dzname;
    }

    public String getDyname() {
        return dyname;
    }

    public void setDyname(String dyname) {
        this.dyname = dyname;
    }

    public String getFhname() {
        return fhname;
    }

    public void setFhname(String fhname) {
        this.fhname = fhname;
    }

    public String getBuildname() {
        return buildname;
    }

    public void setBuildname(String buildname) {
        this.buildname = buildname;
    }

    public Integer getStreettop() {
        return streettop;
    }

    public void setStreettop(Integer streettop) {
        this.streettop = streettop;
    }

    public Integer getFang() {
        return fang;
    }

    public void setFang(Integer fang) {
        this.fang = fang;
    }

    public Integer getTing() {
        return ting;
    }

    public void setTing(Integer ting) {
        this.ting = ting;
    }

    public Integer getWei() {
        return wei;
    }

    public void setWei(Integer wei) {
        this.wei = wei;
    }

    public Integer getYangtai() {
        return yangtai;
    }

    public void setYangtai(Integer yangtai) {
        this.yangtai = yangtai;
    }

    public String getOwnerTel() {
        return ownerTel;
    }

    public void setOwnerTel(String ownerTel) {
        this.ownerTel = ownerTel;
    }

    public Integer getSaletotal() {
        return saletotal;
    }

    public void setSaletotal(Integer saletotal) {
        this.saletotal = saletotal;
    }

    public Integer getZutotal() {
        return zutotal;
    }

    public void setZutotal(Integer zutotal) {
        this.zutotal = zutotal;
    }

    @Override
    public String toString() {
        return "DaoJiaLeHouse{" +
                "houseid=" + houseid +
                ", dealtype='" + dealtype + '\'' +
                ", housetitle='" + housetitle + '\'' +
                ", houseNo='" + houseNo + '\'' +
                ", areaname='" + areaname + '\'' +
                ", districtname='" + districtname + '\'' +
                ", dzname='" + dzname + '\'' +
                ", dyname='" + dyname + '\'' +
                ", fhname='" + fhname + '\'' +
                ", buildname='" + buildname + '\'' +
                ", streettop=" + streettop +
                ", fang=" + fang +
                ", ting=" + ting +
                ", wei=" + wei +
                ", yangtai=" + yangtai +
                ", ownerTel='" + ownerTel + '\'' +
                ", saletotal=" + saletotal +
                ", zutotal=" + zutotal +
                '}';
    }
}
