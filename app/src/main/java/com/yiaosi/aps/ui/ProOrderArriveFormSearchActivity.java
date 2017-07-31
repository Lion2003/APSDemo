package com.yiaosi.aps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.yiaosi.aps.R;
import com.yiaosi.aps.widget.EditItem;
import com.yiaosi.aps.widget.timepickerdlg.TimePickerDialog;
import com.yiaosi.aps.widget.timepickerdlg.data.Type;
import com.yiaosi.aps.widget.timepickerdlg.listener.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生产单到货查询
 * Created by Administrator on 2017-06-07.
 */

public class ProOrderArriveFormSearchActivity extends BaseActivity {
    private EditItem beginDate, endDate, produceNum, stypeNum, dakuan;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_prodorder_arrive_form_search);
        initTitleBar();

        initView();

        initListener();
    }

    private void initView() {
        beginDate = (EditItem) findViewById(R.id.apafs_beginDate);
        endDate = (EditItem) findViewById(R.id.apafs_endDate);
        produceNum = (EditItem) findViewById(R.id.apafs_produceNum);
        stypeNum = (EditItem) findViewById(R.id.apafs_styleNum);
        dakuan = (EditItem) findViewById(R.id.apafs_dakuan);
        btnSearch = (Button) findViewById(R.id.btn_search);
    }

    private void initListener() {
        titleBar.setLeftLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        beginDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData(beginDate);
            }
        });

        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData(endDate);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ProOrderArriveFormSearchActivity.this, ProOrderArriveFormListActivity.class);
                startActivity(it);
            }
        });

    }

    /**
     * 设置时间
     * @param tv
     */
    private void setData(final EditItem tv) {
        TimePickerDialog mDialogYearMonthDay = new TimePickerDialog.Builder()
                .setType(Type.YEAR_MONTH)
                .setCallBack(new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月");
                        Date d = new Date(millseconds);
                        String date = sf.format(d);
                        tv.setValue(date);
                    }
                })
                .build();
        mDialogYearMonthDay.show(getSupportFragmentManager(), "year_month");
    }

}
