package com.yiaosi.aps.mvp.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-06-19.
 */

public class RemindNoticeTypeEntity implements Serializable {
    private int type;
    private String title;
    private int remindNum;

    public RemindNoticeTypeEntity(int type, String title, int remindNum) {
        this.type = type;
        this.remindNum = remindNum;
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRemindNum() {
        return remindNum;
    }

    public void setRemindNum(int remindNum) {
        this.remindNum = remindNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
