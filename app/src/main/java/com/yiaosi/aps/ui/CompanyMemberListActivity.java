package com.yiaosi.aps.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.hyphenate.chatuidemo.ui.ChatActivity;
import com.yiaosi.aps.R;
import com.yiaosi.aps.adapter.CompanyMemberAdapter;
import com.yiaosi.aps.constant.Constant;
import com.yiaosi.aps.entity.CompanyMemberEntity;
import com.yiaosi.aps.entity.CompanyMemberEntity.ResultBean.PageInfoBean.ListBean;
import com.yiaosi.aps.entity.LoginEntity;
import com.yiaosi.aps.utils.ACache;
import com.yiaosi.aps.widget.SpaceItemDecoration;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;

/**
 * 公司的员工列表
 * Created by Administrator on 2017-12-07.
 */

public class CompanyMemberListActivity extends BaseActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private List<ListBean> list;

    private ACache mCache;
    private LoginEntity entity;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_over_audit_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("员工列表");
        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.mipmap);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.aoal_swipe);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);

        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_light,
                android.R.color.holo_green_light);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(10));

        getCompanyMember();
    }

    class Token {
        String token;

        public Token(String token) {
            this.token = token;
        }
    }

    /**
     * 获取用户列表
     */
    private void getCompanyMember() {
        String token = getToken();
        OkHttpUtils
                .postString()
                .addHeader("Authorization", token)
                .url(Constant.companyMember + 1)
                .content(new Gson().toJson(new Token(token)))
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(new CompanyMemberCallback());
    }

    public class CompanyMemberCallback extends StringCallback {
        @Override
        public void onBefore(Request request, int id) {
            Log.e("as", request.toString());
        }

        @Override
        public void onAfter(int id) {
            Log.e("as", id + "");
            swipeRefreshLayout.setRefreshing(false);
        }

        @Override
        public void onError(Call call, Exception e, int id) {
            e.printStackTrace();
        }

        @Override
        public void onResponse(String response, int id) {
            Gson gson = new Gson();
            CompanyMemberEntity entity = gson.fromJson(response, CompanyMemberEntity.class);
            if(entity.getStatus() == 200 && entity.getMsg().equals("success")) {
                list = entity.getResult().getPageInfo().getList();
                CompanyMemberAdapter adapter = new CompanyMemberAdapter(CompanyMemberListActivity.this, list);
                SlideInBottomAnimationAdapter slideAdapter = new SlideInBottomAnimationAdapter(adapter);
                slideAdapter.setDuration(800);
                mRecyclerView.setAdapter(slideAdapter);

                adapter.setOnMyClickListener(new CompanyMemberAdapter.OnMyClickListener() {
                    @Override
                    public void onClick(String id) {
                        Intent intent = new Intent(CompanyMemberListActivity.this, ChatActivity.class);
                        // it is group chat
                        intent.putExtra("chatType", com.hyphenate.chatuidemo.Constant.CHATTYPE_SINGLE);
                        intent.putExtra("userId", id);
                        startActivityForResult(intent, 0);
                    }
                });
            } else {
                Toast.makeText(CompanyMemberListActivity.this, "权限受限", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void inProgress(float progress, long total, int id) {
//            mProgressBar.setProgress((int) (100 * progress));
        }
    }

    private String getToken() {
        mCache = ACache.get(this);
        entity = (LoginEntity) mCache.getAsObject(com.hyphenate.chatuidemo.Constant.LOGINENTITY);
        String token = "";
        if(entity != null) {
            //获取登录接口返回的实体类
            if(entity.getAuthorization() != null) {
                token = entity.getAuthorization().replace("[", "").replace("]", "");
            } else {
                token = "";
            }
        }
        return token;
    }

}
