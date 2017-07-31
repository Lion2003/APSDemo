package com.yiaosi.aps.mvp.view;

import com.yiaosi.aps.mvp.bean.RemindNoticeTypeEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-06-19.
 */

public interface IRemindNoticeView {
    void showLoading();
    void hideLoading();
    void showList(String[] titles, List<RemindNoticeTypeEntity> list);
}
