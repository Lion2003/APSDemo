package com.yiaosi.aps.entity;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/7/24.
 */

public class RemindNoticeDetailEntity implements Serializable {
    private String clientName;  //客户名称
    private String picture;
    private String productionOrderNum;  //生产单号
    private String productionCount;  //生产单数
    private String clientStyleNum;  //客户款号
    private String clientDeliveryTime;  //客户交期
    private String acutralProcess;  //实际进度
    private String backWardProcess;  //进度落后

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getProductionOrderNum() {
        return productionOrderNum;
    }

    public void setProductionOrderNum(String productionOrderNum) {
        this.productionOrderNum = productionOrderNum;
    }

    public String getProductionCount() {
        return productionCount;
    }

    public void setProductionCount(String productionCount) {
        this.productionCount = productionCount;
    }

    public String getClientStyleNum() {
        return clientStyleNum;
    }

    public void setClientStyleNum(String clientStyleNum) {
        this.clientStyleNum = clientStyleNum;
    }

    public String getClientDeliveryTime() {
        return clientDeliveryTime;
    }

    public void setClientDeliveryTime(String clientDeliveryTime) {
        this.clientDeliveryTime = clientDeliveryTime;
    }

    public String getAcutralProcess() {
        return acutralProcess;
    }

    public void setAcutralProcess(String acutralProcess) {
        this.acutralProcess = acutralProcess;
    }

    public String getBackWardProcess() {
        return backWardProcess;
    }

    public void setBackWardProcess(String backWardProcess) {
        this.backWardProcess = backWardProcess;
    }
}
