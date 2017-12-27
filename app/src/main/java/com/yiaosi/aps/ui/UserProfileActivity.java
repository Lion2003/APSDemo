package com.yiaosi.aps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hyphenate.chatuidemo.Constant;
import com.hyphenate.chatuidemo.DemoApplication;
import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.hyphenate.chatuidemo.ui.ChatActivity;
import com.yiaosi.aps.R;
import com.yiaosi.aps.entity.LoginEntity;
import com.yiaosi.aps.utils.ACache;
import com.yiaosi.aps.widget.EditItem;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Request;

/**
 * Created by Administrator on 2017-06-13.
 */

public class UserProfileActivity extends BaseActivity {
    private CardView cardView;
    private EditItem phone, homePhone, email;
    private FloatingActionButton fab;
    private Button btnSendMsg;

    private boolean isChat;
    private String member;

    private TextView companyName;  //工厂名称
    private TextView userName;  //用户名
    private TextView position;  //职位
    private TextView tvName;
    private TextView tvFactory;


    private ACache mCache;
    private LoginEntity entity;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_user_profile);
        isChat = getIntent().getBooleanExtra("isChat", true);
        member = getIntent().getStringExtra(Constant.EXTRA_USER_ID);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("个人信息");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        companyName = (TextView) findViewById(R.id.aup_factory);  //工厂名称
        userName = (TextView) findViewById(R.id.aup_userName);  //用户名
        position = (TextView) findViewById(R.id.aup_position);  //职位
        tvName = (TextView) findViewById(R.id.tvName);  //
        tvFactory = (TextView) findViewById(R.id.tvfactory);  //

        cardView = (CardView) findViewById(R.id.cardView);
        phone = (EditItem) findViewById(R.id.aup_phone);
        homePhone = (EditItem) findViewById(R.id.aup_homePhone);
        email = (EditItem) findViewById(R.id.aup_email);
        phone.setValuePos(Gravity.LEFT);
        homePhone.setValuePos(Gravity.LEFT);
        email.setValuePos(Gravity.LEFT);

        btnSendMsg = (Button) findViewById(R.id.aup_btnSendMsg);
        if(isChat) {
            btnSendMsg.setVisibility(View.VISIBLE);
        } else {
            btnSendMsg.setVisibility(View.GONE);
        }

        btnSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, ChatActivity.class);
                // it's single chat
                intent.putExtra(Constant.EXTRA_USER_ID, member);
                startActivity(intent);
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, UserProfileDetailActivity.class);
                startActivity(intent);
            }
        });

//        getUserInfo();
        getCache();
    }

    /**
     * 获取某个用户信息
     */
    private void getUserInfo() {
        OkHttpUtils
                .get()
                .url(com.yiaosi.aps.constant.Constant.user + DemoApplication.loginEntity.getUserUuid())
                .build()
                .execute(new UserInfoCallback());
    }
    public class UserInfoCallback extends StringCallback {
        @Override
        public void onBefore(Request request, int id) {
            Log.e("as", request.toString());
        }

        @Override
        public void onAfter(int id) {
            Log.e("as", id + "");
        }

        @Override
        public void onError(Call call, Exception e, int id) {
            e.printStackTrace();
        }

        @Override
        public void onResponse(String response, int id) {
            Gson gson = new Gson();
            LoginEntity entity = gson.fromJson(response, LoginEntity.class);
//            if(entity.getStatus() == 200 && entity.getMsg().equals("success")) {
//
//            } else {
//                Toast.makeText(UserProfileActivity.this, "服务繁忙", Toast.LENGTH_SHORT).show();
//            }
        }

        @Override
        public void inProgress(float progress, long total, int id) {
//            mProgressBar.setProgress((int) (100 * progress));
        }
    }

    private void getCache() {
        mCache = ACache.get(this);
        entity = read();
        if(entity != null) {
            //获取登录接口返回的实体类
            if(entity != null) {
                companyName.setText("");  //工厂名称
                userName.setText(entity.getUsername());  //用户名
                position.setText("");  //职位
                phone.setValue(entity.getUsername());
                homePhone.setValue("");
                email.setValue("");
                tvName.setText("");
                tvFactory.setText("");
            }
        }
    }

    /**
     * 从缓存获取行政人事的实体类
     */
    public LoginEntity read() {
        LoginEntity filmDB = (LoginEntity) mCache.getAsObject(Constant.LOGINENTITY);
        if (filmDB == null) {
            return null;
        } else {
            return filmDB;
        }
    }
}
