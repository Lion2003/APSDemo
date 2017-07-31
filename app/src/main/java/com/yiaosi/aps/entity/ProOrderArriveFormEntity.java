package com.yiaosi.aps.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-06-09.
 */

public class ProOrderArriveFormEntity implements Serializable {

    private String produceOrderNum;  //生产单号
    private String deliveryDate;  //交货期
    private String dakuan;  //大款
    private String styleNum;  //款号
    private String num;  //数量

    public String getProduceOrderNum() {
        return produceOrderNum;
    }

    public void setProduceOrderNum(String produceOrderNum) {
        this.produceOrderNum = produceOrderNum;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDakuan() {
        return dakuan;
    }

    public void setDakuan(String dakuan) {
        this.dakuan = dakuan;
    }

    public String getStyleNum() {
        return styleNum;
    }

    public void setStyleNum(String styleNum) {
        this.styleNum = styleNum;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

}
