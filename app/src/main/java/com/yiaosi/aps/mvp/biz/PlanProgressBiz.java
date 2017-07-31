package com.yiaosi.aps.mvp.biz;

import com.yiaosi.aps.mvp.bean.PlanProgressEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-06-19.
 */

public class PlanProgressBiz implements IPlanProgressBiz {

    @Override
    public void getPlanProgress(final OnPlanProgressListener planProgressListener) {
        //模拟子线程耗时操作
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //模拟接口调用成功
                if(true) {
                    List<PlanProgressEntity> list = new ArrayList<PlanProgressEntity>();
                    PlanProgressEntity entity;
                    for(int i = 0; i < 50; i++) {
                        entity = new PlanProgressEntity();
                        entity.setProductOrder("143013-035"); //生产单号
                        entity.setClientName("英氏" + i); //客户名称
                        entity.setProductOrderNum("700"); //生产单数
                        entity.setClientName("CBKJ008" + i); //客户款号
                        entity.setStyleDesc("枕头（定型枕）" + i); //款式描述
                        entity.setPlanBeginDate("2016-12-19"); //计划开始日期
                        entity.setPlanEndDate("2017-01-10"); //计划完成日期
                        entity.setActualProgress("68%"); //实际进度
                        entity.setBackwordProgress("32%"); //进度落后

                        list.add(entity);
                    }
                    planProgressListener.getPlanProgressSuccess(list);
                } else {
                    planProgressListener.getPlanProgressFaile();
                }

            }
        }.start();
    }
}
