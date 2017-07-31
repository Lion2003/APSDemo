package com.yiaosi.aps.entity;

import java.io.Serializable;

/**
 * 外协厂实体类
 * Created by Administrator on 2017-07-21.
 */

public class OutSourcingFactoryEntity implements Serializable {
    private String productOrderNum; //生产单号
    private String productionLine; //生产线
    private String styleNum; //款号
    private String beginDate; //开始日期
    private String totalCount; //总数量
    private String workShopDeliveryTime; //车间交期
    private String specifications; //规格
    private String endDate; //结束日期
    private String completedNum; //已完成数

    public String getProductOrderNum() {
        return productOrderNum;
    }

    public void setProductOrderNum(String productOrderNum) {
        this.productOrderNum = productOrderNum;
    }

    public String getProductionLine() {
        return productionLine;
    }

    public void setProductionLine(String productionLine) {
        this.productionLine = productionLine;
    }

    public String getStyleNum() {
        return styleNum;
    }

    public void setStyleNum(String styleNum) {
        this.styleNum = styleNum;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getWorkShopDeliveryTime() {
        return workShopDeliveryTime;
    }

    public void setWorkShopDeliveryTime(String workShopDeliveryTime) {
        this.workShopDeliveryTime = workShopDeliveryTime;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCompletedNum() {
        return completedNum;
    }

    public void setCompletedNum(String completedNum) {
        this.completedNum = completedNum;
    }
}
