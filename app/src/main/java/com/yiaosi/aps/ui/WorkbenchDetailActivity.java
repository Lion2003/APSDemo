package com.yiaosi.aps.ui;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.yiaosi.aps.R;
import com.yiaosi.aps.adapter.WorkbenchDetailAdapter;

/**
 * Created by Administrator on 2017-07-25.
 */

public class WorkbenchDetailActivity extends BaseActivity {
    private ImageView img;
    private RecyclerView mRecyclerView;
    private String pic;
    private String isShow;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_work_bench_detail);
        img = (ImageView) findViewById(R.id.imageView);
        pic = getIntent().getStringExtra("pic");
        isShow = getIntent().getStringExtra("isShow");
        Glide.with(this).load(pic).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(img);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        mToolbar.setLogo(R.drawable.ic_launcher);
//        mToolbar.setNavigationIcon(android.R.drawable.ic_menu_delete);
        mToolbar.setTitle("详情");
        //mToolbar.setSubtitle("zhangphil副标题");
        //mToolbar.setSubtitleTextColor(Color.RED);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        WorkbenchDetailAdapter adapter = new WorkbenchDetailAdapter(this, isShow);
        mRecyclerView.setAdapter(adapter);
    }
}
