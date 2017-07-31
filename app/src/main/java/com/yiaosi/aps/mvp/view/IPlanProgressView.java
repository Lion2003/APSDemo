package com.yiaosi.aps.mvp.view;

import com.yiaosi.aps.mvp.bean.PlanProgressEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-06-19.
 */

public interface IPlanProgressView {
    void showLoading();
    void hideLoading();
    void showList(List<PlanProgressEntity> list);
}
