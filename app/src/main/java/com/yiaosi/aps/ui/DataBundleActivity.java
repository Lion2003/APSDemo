package com.yiaosi.aps.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.hyphenate.chatuidemo.utils.SharedPreferencesUtil;
import com.yiaosi.aps.R;
import com.yiaosi.aps.utils.StringUtil;

/**
 * Created by Administrator on 2017-12-20.
 */

public class DataBundleActivity extends BaseActivity {
    private EditText edBundle; // 18924229955
    private Button btn;
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_data_bundle);
        edBundle = (EditText) findViewById(R.id.adb_dataBundle);
        btn = (Button) findViewById(R.id.eal_btnLogin);

        Toolbar bar = (Toolbar) findViewById(R.id.toolbar);
        bar.setTitle("数据绑定");
        setSupportActionBar(bar);
        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        edBundle.setText(SharedPreferencesUtil.getInstance().getDataBundle());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StringUtil.isEmpty(edBundle.getText().toString())) {
                    Toast.makeText(DataBundleActivity.this, "请输入URL", Toast.LENGTH_SHORT).show();
                    return;
                }
                SharedPreferencesUtil.getInstance().setDataBundle(edBundle.getText().toString());
                Toast.makeText(DataBundleActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
