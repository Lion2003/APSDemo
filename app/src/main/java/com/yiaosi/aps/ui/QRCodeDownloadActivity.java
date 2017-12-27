package com.yiaosi.aps.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.yiaosi.aps.R;

/**
 * Created by Administrator on 2017-12-27.
 */

public class QRCodeDownloadActivity  extends BaseActivity {
    private ImageView qrcode;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_qrcode);
        Toolbar bar = (Toolbar) findViewById(R.id.toolbar);
        bar.setTitle("扫码下载app");
        setSupportActionBar(bar);
        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        qrcode = (ImageView) findViewById(R.id.qrcode1);
        qrcode.setImageResource(R.mipmap.icon_qr_download);
    }
}