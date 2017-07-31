package com.yiaosi.aps.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.yiaosi.aps.R;

/**
 * Created by Administrator on 2017-07-24.
 */

public class ColorNumInputActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_color_num_input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.mipmap);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
