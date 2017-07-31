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
import com.yiaosi.aps.adapter.OverAuditingAdapter;
import com.yiaosi.aps.adapter.StockFormAdapter;
import com.yiaosi.aps.entity.OverAuditingEntity;
import com.yiaosi.aps.entity.StockFormEntity;
import com.yiaosi.aps.widget.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;

/**
 * 库存报表列表
 * Created by Administrator on 2017-06-09.
 */

public class StockFormListActivity extends BaseActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private List<StockFormEntity> list;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_stock_form_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("库存报表");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.asfl_swipe);
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
        list = new ArrayList<StockFormEntity>();
        StockFormEntity entity;
        for(int i = 0; i < 70; i++) {
            entity = new StockFormEntity();
            entity.setClientName("英氏" + i);
            entity.setDakuanName("17春夏外服" + i);
            entity.setMaterielType("线" + i);
            entity.setMaterielName("高士402PP线" + i);
            entity.setColor("米色" + i);
            entity.setSpecifi(i + "个");
            entity.setColorNum("C17157");
            entity.setBeginPeriodNum(i + "个");
            entity.setInStorageNum(i + "个");
            entity.setOutStorageNum(i + "个");
            entity.setBalanceNum(i + "个");
            entity.setProducNumber("13495-0" + i);
            list.add(entity);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                StockFormAdapter adapter = new StockFormAdapter(StockFormListActivity.this, list);
                SlideInBottomAnimationAdapter slideAdapter = new SlideInBottomAnimationAdapter(adapter);
                slideAdapter.setDuration(800);
                mRecyclerView.setAdapter(slideAdapter);
                swipeRefreshLayout.setRefreshing(false);
            }
        },1000);
    }

}
