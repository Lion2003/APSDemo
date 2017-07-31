package com.yiaosi.aps.mvp.biz;

import com.yiaosi.aps.mvp.bean.RemindNoticeTypeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-06-19.
 */

public class RemindNoticeBiz implements IRemindNoticeBiz {
    @Override
    public void getRemindNotice(final OnRemindNoticeListener remindNoticeListener) {
        //模拟子线程耗时操作
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(50);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                //模拟接口调用成功
                if(true) {
                    String[] titles = {"生产计划", "生产单", "物料跟催", "关键事件"};

                    List<RemindNoticeTypeEntity> list = new ArrayList<RemindNoticeTypeEntity>();
                    list.add(new RemindNoticeTypeEntity(2, "生产计划进度落后单", 12));
                    list.add(new RemindNoticeTypeEntity(2, "今天开始的生产计划单", 18));
                    list.add(new RemindNoticeTypeEntity(2, "今天结束的生产计划单", 6));
                    list.add(new RemindNoticeTypeEntity(2, "七天内开始的生产计划单", 37));
                    list.add(new RemindNoticeTypeEntity(2, "正在进行的生产计划单", 5));
                    //=====
                    list.add(new RemindNoticeTypeEntity(2, "未排生产单", 7));
                    list.add(new RemindNoticeTypeEntity(2, "一周内新增生产单", 11));
                    list.add(new RemindNoticeTypeEntity(2, "一周内有变更已排生产单", 3));
                    //=====
                    list.add(new RemindNoticeTypeEntity(2, "未到货的单", 8));
                    list.add(new RemindNoticeTypeEntity(2, "一周内将要到货的单", 19));
                    //=====
                    list.add(new RemindNoticeTypeEntity(2, "未结束事件", 8));
                    list.add(new RemindNoticeTypeEntity(2, "一周内结束事件", 19));
                    list.add(new RemindNoticeTypeEntity(2, "当月内结束事件", 19));
                    list.add(new RemindNoticeTypeEntity(2, "一周内变更事件", 19));
                    remindNoticeListener.getRemindNoticeSuccess(titles, list);
                } else {
                    remindNoticeListener.getRemindNoticeFailed();
                }
            }
        }.start();
    }
}
