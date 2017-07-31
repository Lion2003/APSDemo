package com.yiaosi.aps.mvp.presenter;

import android.os.Handler;

import com.yiaosi.aps.mvp.bean.RemindNoticeTypeEntity;
import com.yiaosi.aps.mvp.biz.IRemindNoticeBiz;
import com.yiaosi.aps.mvp.biz.OnRemindNoticeListener;
import com.yiaosi.aps.mvp.biz.RemindNoticeBiz;
import com.yiaosi.aps.mvp.view.IRemindNoticeView;

import java.util.List;

/**
 * Created by Administrator on 2017-06-19.
 */

public class RemindNoticePresenter {
    private IRemindNoticeBiz remindNoticeBiz;
    private IRemindNoticeView remindNoticeView;
    private Handler mHandler = new Handler();

    public RemindNoticePresenter(IRemindNoticeView remindNoticeView) {
        this.remindNoticeView = remindNoticeView;
        this.remindNoticeBiz = new RemindNoticeBiz();
    }

    public void getRemindNoticeList() {
        remindNoticeView.showLoading();
        remindNoticeBiz.getRemindNotice(new OnRemindNoticeListener() {
            @Override
            public void getRemindNoticeSuccess(final String[] titles, final List<RemindNoticeTypeEntity> list) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        remindNoticeView.showList(titles, list);
                        remindNoticeView.hideLoading();
                    }
                });
            }

            @Override
            public void getRemindNoticeFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        remindNoticeView.hideLoading();
                    }
                });
            }
        });
    }


























}
