package com.yiaosi.aps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.hyphenate.chatuidemo.db.UserDao;
import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.hyphenate.easeui.domain.EaseUser;
import com.yiaosi.aps.R;
import com.yiaosi.aps.entity.OutSourcingFactoryEntity;
import com.yiaosi.aps.entity.OutSourcingFactoryManagerAdapter;
import com.yiaosi.aps.widget.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;

/**
 * 外协厂管理
 * Created by Administrator on 2017-07-21.
 */

public class OutSourcingFactoryManagerActivity extends BaseActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private List<OutSourcingFactoryEntity> list;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_outsourcingfactory_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("外协厂管理");
        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.mipmap);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.aol_swipe);
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
//        mRecyclerView.addItemDecoration(new SpaceItemDecoration(10));

        initData();

//        UserDao dao=new UserDao(this);
//        Map<String, EaseUser> kk = dao.getContactList();
//        Log.e("sad", kk.toString());
    }

    private void initData() {
        list = new ArrayList<OutSourcingFactoryEntity>();
//        OutSourcingFactoryEntity entity;
//        for(int i = 0; i < 50; i++) {
//            entity = new OutSourcingFactoryEntity();
//            entity.setProductOrderNum("162303-002");
//            entity.setProductionLine("G-2（梭+衣）");
//            entity.setStyleNum("休闲裤");
//            entity.setBeginDate("2017-03-21");
//            entity.setTotalCount("790");
//            entity.setWorkShopDeliveryTime("2017-04-13" + i);
//            entity.setSpecifications("S,M,L,XL");
//            entity.setEndDate("2017-04-08");
//            entity.setCompletedNum("468");
//            list.add(entity);
//        }
        OutSourcingFactoryEntity entity0 = new OutSourcingFactoryEntity();
        entity0.setProductOrderNum("172303-001");
        entity0.setProductionLine("G-2（梭+衣）");
        entity0.setStyleNum("休闲裤");
        entity0.setBeginDate("2017-07-22");
        entity0.setTotalCount("790");
        entity0.setWorkShopDeliveryTime("2017-08-12");
        entity0.setSpecifications("S M L XL");
        entity0.setEndDate("2017-08-08");
        entity0.setCompletedNum("468");
        list.add(entity0);

        OutSourcingFactoryEntity entity1 = new OutSourcingFactoryEntity();
        entity1.setProductOrderNum("172306-002");
        entity1.setProductionLine("G-2（梭+衣）");
        entity1.setStyleNum("休闲裤");
        entity1.setBeginDate("2017-07-24");
        entity1.setTotalCount("900");
        entity1.setWorkShopDeliveryTime("2017-08-16");
        entity1.setSpecifications("S M L XL");
        entity1.setEndDate("2017-08-10");
        entity1.setCompletedNum("200");
        list.add(entity1);

        OutSourcingFactoryEntity entity2 = new OutSourcingFactoryEntity();
        entity2.setProductOrderNum("172306-003");
        entity2.setProductionLine("G-2（梭+衣）");
        entity2.setStyleNum("T恤");
        entity2.setBeginDate("2017-07-26");
        entity2.setTotalCount("800");
        entity2.setWorkShopDeliveryTime("2017-08-20");
        entity2.setSpecifications("S M L XL");
        entity2.setEndDate("2017-08-12");
        entity2.setCompletedNum("100");
        list.add(entity2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                OutSourcingFactoryManagerAdapter adapter = new OutSourcingFactoryManagerAdapter(OutSourcingFactoryManagerActivity.this, list);
                SlideInBottomAnimationAdapter slideAdapter = new SlideInBottomAnimationAdapter(adapter);
                slideAdapter.setDuration(800);
                mRecyclerView.setAdapter(slideAdapter);
                swipeRefreshLayout.setRefreshing(false);

                adapter.setOnItemClickListener(new OutSourcingFactoryManagerAdapter.setOnClick() {
                    @Override
                    public void onClick() {
                        Intent it = new Intent(OutSourcingFactoryManagerActivity.this, ColorNumInputActivity.class);
                        startActivity(it);
                    }
                });
            }
        },1000);

    }
}
