package com.yiaosi.aps.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-06-05.
 */

public class WorkbenchItem implements Serializable {
    private String customerName;
    private String pic;
    private String productOrderNum;
    private String customerDate;
    private String styleNum;
    private String num;
    private String color;
    private String isFinish = "0";

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getProductOrderNum() {
        return productOrderNum;
    }

    public void setProductOrderNum(String productOrderNum) {
        this.productOrderNum = productOrderNum;
    }

    public String getCustomerDate() {
        return customerDate;
    }

    public void setCustomerDate(String customerDate) {
        this.customerDate = customerDate;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(String isFinish) {
        this.isFinish = isFinish;
    }
}
