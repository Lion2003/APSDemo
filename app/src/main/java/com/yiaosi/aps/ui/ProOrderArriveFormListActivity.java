package com.yiaosi.aps.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.yiaosi.aps.R;
import com.yiaosi.aps.adapter.ProOrderArriveFormAdapter;
import com.yiaosi.aps.adapter.StockFormAdapter;
import com.yiaosi.aps.entity.ProOrderArriveFormEntity;
import com.yiaosi.aps.entity.StockFormEntity;
import com.yiaosi.aps.widget.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;

/**
 * Created by Administrator on 2017-06-09.
 */

public class ProOrderArriveFormListActivity extends BaseActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private List<ProOrderArriveFormEntity> list;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_prodorder_arrive_form_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("物料到货单");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.apafl_swipe);
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
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(10));

        initData();

    }

    private void initData() {
        list = new ArrayList<ProOrderArriveFormEntity>();
        ProOrderArriveFormEntity entity;
        for(int i = 0; i < 70; i++) {
            entity = new ProOrderArriveFormEntity();
            entity.setProduceOrderNum("VL318368-01");
            entity.setDeliveryDate("2017-11-10");
            entity.setDakuan("罗莱内衣系列" + i);
            entity.setStyleNum("VL318368");
            entity.setNum("" + i);
            list.add(entity);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ProOrderArriveFormAdapter adapter = new ProOrderArriveFormAdapter(ProOrderArriveFormListActivity.this, list);
                SlideInBottomAnimationAdapter slideAdapter = new SlideInBottomAnimationAdapter(adapter);
                slideAdapter.setDuration(800);
                mRecyclerView.setAdapter(slideAdapter);
                swipeRefreshLayout.setRefreshing(false);
            }
        },1000);
    }




















}
