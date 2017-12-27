package com.yiaosi.aps.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.yiaosi.aps.R;
import com.yiaosi.aps.constant.Constant;
import com.yiaosi.aps.entity.LoginEntity;
import com.yiaosi.aps.utils.ACache;
import com.yiaosi.aps.utils.QRCode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2017-12-07.
 */

public class QRCodeActivity extends BaseActivity {
    private ImageView qrcode;

    private ACache mCache;
    private LoginEntity entity;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_qrcode);
        Toolbar bar = (Toolbar) findViewById(R.id.toolbar);
        bar.setTitle("企业二维码");
        setSupportActionBar(bar);
        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        qrcode = (ImageView) findViewById(R.id.qrcode1);
//        Toast.makeText(this, Environment.getExternalStorageDirectory() + ",", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getCache();
    }

    /**
     * 保存bitmap到本地
     *
     * @param context
     * @param mBitmap
     * @return
     */
    public static String saveBitmap(Context context, Bitmap mBitmap) {
        File filePic;
        try {
            filePic = new File(Environment.getExternalStorageDirectory() + "/企业二维码.jpg");
            if (!filePic.exists()) {
                filePic.getParentFile().mkdirs();
                filePic.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(filePic);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return filePic.getAbsolutePath();
    }

    private void getCache() {
        mCache = ACache.get(this);
        entity = read();
        if(entity != null) {
            //获取登录接口返回的实体类
            if(entity.getAuthorization() != null) {
                String id = entity.getCompanyUuid().replace("[", "").replace("]", "");
                Bitmap bitmap = QRCode.createQRCode(Constant.QRCode + id);
                saveBitmap(this, bitmap);
                qrcode.setImageBitmap(bitmap);
                Toast.makeText(this, Constant.QRCode + entity.getCompanyUuid(), Toast.LENGTH_SHORT).show();
            } else {
                Bitmap bitmap = QRCode.createQRCode(Constant.QRCode + "这里填企业ID");
                saveBitmap(this, bitmap);

                qrcode.setImageBitmap(bitmap);
            }
        } else {
            Bitmap bitmap = QRCode.createQRCode(Constant.QRCode + "这里填企业ID");
            saveBitmap(this, bitmap);
            qrcode.setImageBitmap(bitmap);
        }
    }

    /**
     * 从缓存获取行政人事的实体类
     */
    public LoginEntity read() {
        LoginEntity filmDB = (LoginEntity) mCache.getAsObject(com.hyphenate.chatuidemo.Constant.LOGINENTITY);
        if (filmDB == null) {
            return null;
        } else {
            return filmDB;
        }
    }
}
