package com.yiaosi.aps.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.yiaosi.aps.R;
import com.yiaosi.aps.widget.EditItem;
import com.yiaosi.aps.widget.timepickerdlg.TimePickerDialog;
import com.yiaosi.aps.widget.timepickerdlg.data.Type;
import com.yiaosi.aps.widget.timepickerdlg.listener.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 宏观计划
 * Created by Administrator on 2017-06-07.
 */

public class MacroPlanActivity extends BaseActivity {
    private EditItem tvBeginDate, tvEndDate;
    private RadioGroup radioGroup;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macro_plan);
        initTitleBar();
        initView();
        initListener();
    }

    private void initView() {
        tvBeginDate = (EditItem) findViewById(R.id.amp_beginDate);
        tvEndDate = (EditItem) findViewById(R.id.amp_endDate);
        radioGroup = (RadioGroup) findViewById(R.id.amp_radioGroup);
        btnSearch = (Button) findViewById(R.id.btn_search);
    }

    private void initListener(){
        titleBar.setLeftLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvBeginDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData(tvBeginDate);
            }
        });

        tvEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData(tvEndDate);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.amp_gcjq:
                        Toast.makeText(MacroPlanActivity.this, "工厂交期", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.amp_jhq:
                        Toast.makeText(MacroPlanActivity.this, "交货期", Toast.LENGTH_SHORT).show();
                        break;
                    default:

                        break;
                }
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
