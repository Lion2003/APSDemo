package com.yiaosi.aps.mvp.biz;

import com.yiaosi.aps.mvp.bean.RemindNoticeTypeEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-06-19.
 */

public interface OnRemindNoticeListener {

    void getRemindNoticeSuccess(String[] titles, List<RemindNoticeTypeEntity> list);
    void getRemindNoticeFailed();
}
