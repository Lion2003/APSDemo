package com.yiaosi.aps.mvp.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-06-19.
 */

public class PlanProgressEntity implements Serializable {

    private String productOrder; //生产单号
    private String clientName; //客户名称
    private String productOrderNum; //生产单数
    private String clientStyleNum; //客户款号
    private String styleDesc; //款式描述
    private String planBeginDate; //计划开始日期
    private String planEndDate; //计划完成日期
    private String actualProgress; //实际进度
    private String backwordProgress; //进度落后

    public String getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(String productOrder) {
        this.productOrder = productOrder;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProductOrderNum() {
        return productOrderNum;
    }

    public void setProductOrderNum(String productOrderNum) {
        this.productOrderNum = productOrderNum;
    }

    public String getClientStyleNum() {
        return clientStyleNum;
    }

    public void setClientStyleNum(String clientStyleNum) {
        this.clientStyleNum = clientStyleNum;
    }

    public String getStyleDesc() {
        return styleDesc;
    }

    public void setStyleDesc(String styleDesc) {
        this.styleDesc = styleDesc;
    }

    public String getPlanBeginDate() {
        return planBeginDate;
    }

    public void setPlanBeginDate(String planBeginDate) {
        this.planBeginDate = planBeginDate;
    }

    public String getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(String planEndDate) {
        this.planEndDate = planEndDate;
    }

    public String getActualProgress() {
        return actualProgress;
    }

    public void setActualProgress(String actualProgress) {
        this.actualProgress = actualProgress;
    }

    public String getBackwordProgress() {
        return backwordProgress;
    }

    public void setBackwordProgress(String backwordProgress) {
        this.backwordProgress = backwordProgress;
    }
}
