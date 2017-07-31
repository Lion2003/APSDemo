package com.yiaosi.aps.mvp.biz;

import com.yiaosi.aps.mvp.bean.PlanProgressEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-06-19.
 */

public interface OnPlanProgressListener {
    void getPlanProgressSuccess(List<PlanProgressEntity> list);
    void getPlanProgressFaile();
}
