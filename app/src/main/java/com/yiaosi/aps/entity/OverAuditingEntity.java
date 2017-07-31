package com.yiaosi.aps.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-06-08.
 */

public class OverAuditingEntity implements Serializable {

    private String orderNum; //单号
    private String type; //类型
    private String materielType; //车间物料
    private String materielnum; //物料编号
    private String materielName; //物料名称
    private String materielSpecifi; //物料规格
    private String OrderQuantity; //订货数量
    private String InWarehouseNumCurrent; //现入仓数
    private String InWarehouseNumTotal;   //总入仓数
    private String auditStatus; //审核状态

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterielType() {
        return materielType;
    }

    public void setMaterielType(String materielType) {
        this.materielType = materielType;
    }

    public String getMaterielnum() {
        return materielnum;
    }

    public void setMaterielnum(String materielnum) {
        this.materielnum = materielnum;
    }

    public String getMaterielName() {
        return materielName;
    }

    public void setMaterielName(String materielName) {
        this.materielName = materielName;
    }

    public String getMaterielSpecifi() {
        return materielSpecifi;
    }

    public void setMaterielSpecifi(String materielSpecifi) {
        this.materielSpecifi = materielSpecifi;
    }

    public String getOrderQuantity() {
        return OrderQuantity;
    }

    public void setOrderQuantity(String orderQuantity) {
        OrderQuantity = orderQuantity;
    }

    public String getInWarehouseNumCurrent() {
        return InWarehouseNumCurrent;
    }

    public void setInWarehouseNumCurrent(String inWarehouseNumCurrent) {
        InWarehouseNumCurrent = inWarehouseNumCurrent;
    }

    public String getInWarehouseNumTotal() {
        return InWarehouseNumTotal;
    }

    public void setInWarehouseNumTotal(String inWarehouseNumTotal) {
        InWarehouseNumTotal = inWarehouseNumTotal;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

}
