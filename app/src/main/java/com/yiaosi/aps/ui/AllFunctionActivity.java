package com.yiaosi.aps.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.yiaosi.aps.R;

/**
 * Created by Administrator on 2017-09-07.
 */

public class AllFunctionActivity extends BaseActivity implements View.OnClickListener {
    private TextView scddhb, kcbb, scpcb, wjdbb, mrclb, hgjh, clsh, wcslr, jdlhd, jrksd, jrjsd, qtnksdd,
          wpscd, yznxzd, yznbgdd, zycg, scdcg;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_all_function);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("全部应用");
        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.mipmap);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        scddhb = (TextView) findViewById(R.id.scddhb);
        kcbb = (TextView) findViewById(R.id.kcbb);
        scpcb = (TextView) findViewById(R.id.scpcb);
        wjdbb = (TextView) findViewById(R.id.wjdbb);
        mrclb = (TextView) findViewById(R.id.mrclb);
        hgjh = (TextView) findViewById(R.id.hgjh);
        clsh = (TextView) findViewById(R.id.clsh);
        wcslr = (TextView) findViewById(R.id.wcslr);
        jdlhd = (TextView) findViewById(R.id.jdlhd);
        jrksd = (TextView) findViewById(R.id.jrksd);
        jrjsd = (TextView) findViewById(R.id.jrjsd);
        qtnksdd = (TextView) findViewById(R.id.qtnksdd);
        wpscd = (TextView) findViewById(R.id.wpscd);
        yznxzd = (TextView) findViewById(R.id.yznxzd);
        yznbgdd = (TextView) findViewById(R.id.yznbgdd);
        zycg = (TextView) findViewById(R.id.zycg);
        scdcg = (TextView) findViewById(R.id.scdcg);


        scddhb.setOnClickListener(this);
        kcbb.setOnClickListener(this);
        scpcb.setOnClickListener(this);
        wjdbb.setOnClickListener(this);
        mrclb.setOnClickListener(this);
        hgjh.setOnClickListener(this);
        clsh.setOnClickListener(this);
        wcslr.setOnClickListener(this);
        jdlhd.setOnClickListener(this);
        jrksd.setOnClickListener(this);
        jrjsd.setOnClickListener(this);
        qtnksdd.setOnClickListener(this);
        wpscd.setOnClickListener(this);
        yznxzd.setOnClickListener(this);
        yznbgdd.setOnClickListener(this);
        zycg.setOnClickListener(this);
        scdcg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
