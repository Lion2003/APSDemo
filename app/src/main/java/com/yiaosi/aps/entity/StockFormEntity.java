package com.yiaosi.aps.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-06-09.
 */

public class StockFormEntity implements Serializable {

    private String clientName; //客户名称
    private String dakuanName; //大款名称
    private String materielType; //物料类型
    private String materielName; //物料名称
    private String color; //颜色
    private String specifi; //规格
    private String colorNum; //色号
    private String beginPeriodNum; //期初数
    private String inStorageNum; //入库数
    private String outStorageNum; //出库数
    private String balanceNum; //结存数
    private String producNumber ; //生产单号

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDakuanName() {
        return dakuanName;
    }

    public void setDakuanName(String dakuanName) {
        this.dakuanName = dakuanName;
    }

    public String getMaterielType() {
        return materielType;
    }

    public void setMaterielType(String materielType) {
        this.materielType = materielType;
    }

    public String getMaterielName() {
        return materielName;
    }

    public void setMaterielName(String materielName) {
        this.materielName = materielName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpecifi() {
        return specifi;
    }

    public void setSpecifi(String specifi) {
        this.specifi = specifi;
    }

    public String getColorNum() {
        return colorNum;
    }

    public void setColorNum(String colorNum) {
        this.colorNum = colorNum;
    }

    public String getBeginPeriodNum() {
        return beginPeriodNum;
    }

    public void setBeginPeriodNum(String beginPeriodNum) {
        this.beginPeriodNum = beginPeriodNum;
    }

    public String getInStorageNum() {
        return inStorageNum;
    }

    public void setInStorageNum(String inStorageNum) {
        this.inStorageNum = inStorageNum;
    }

    public String getOutStorageNum() {
        return outStorageNum;
    }

    public void setOutStorageNum(String outStorageNum) {
        this.outStorageNum = outStorageNum;
    }

    public String getBalanceNum() {
        return balanceNum;
    }

    public void setBalanceNum(String balanceNum) {
        this.balanceNum = balanceNum;
    }

    public String getProducNumber() {
        return producNumber;
    }

    public void setProducNumber(String producNumber) {
        this.producNumber = producNumber;
    }
}
