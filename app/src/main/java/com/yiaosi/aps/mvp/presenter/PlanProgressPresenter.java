package com.yiaosi.aps.mvp.presenter;

import android.os.Handler;

import com.yiaosi.aps.mvp.bean.PlanProgressEntity;
import com.yiaosi.aps.mvp.biz.IPlanProgressBiz;
import com.yiaosi.aps.mvp.biz.OnPlanProgressListener;
import com.yiaosi.aps.mvp.biz.PlanProgressBiz;
import com.yiaosi.aps.mvp.view.IPlanProgressView;

import java.util.List;

/**
 * Created by Administrator on 2017-06-19.
 */

public class PlanProgressPresenter {
    private IPlanProgressView planProgressView;
    private IPlanProgressBiz planProgressBiz;
    private Handler mHandler = new Handler();

    public PlanProgressPresenter(IPlanProgressView planProgressView) {
        this.planProgressView = planProgressView;
        this.planProgressBiz = new PlanProgressBiz();
    }

    public void getPlanProgressList() {
        planProgressView.showLoading();
        planProgressBiz.getPlanProgress(new OnPlanProgressListener() {
            @Override
            public void getPlanProgressSuccess(List<PlanProgressEntity> list) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        planProgressView.showLoading();
                        planProgressView.hideLoading();
                    }
                });
            }

            @Override
            public void getPlanProgressFaile() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        planProgressView.hideLoading();
                    }
                });
            }
        });
    }
}
