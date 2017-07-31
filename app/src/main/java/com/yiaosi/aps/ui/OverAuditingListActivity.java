package com.yiaosi.aps.ui;

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
import com.yiaosi.aps.adapter.OverAuditingAdapter;
import com.yiaosi.aps.entity.OverAuditingEntity;
import com.yiaosi.aps.widget.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;

/**
 * 超量审批列表
 * Created by Administrator on 2017-06-08.
 */

public class OverAuditingListActivity extends BaseActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private List<OverAuditingEntity> list;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_over_audit_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("超量查询");
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

        initData();

        UserDao dao=new UserDao(this);
        Map<String, EaseUser> kk = dao.getContactList();
        Log.e("sad", kk.toString());
    }

    private void initData() {
        list = new ArrayList<OverAuditingEntity>();
        OverAuditingEntity entity;
        for(int i = 0; i < 70; i++) {
            entity = new OverAuditingEntity();
            entity.setOrderNum("In-201612010032");
            entity.setType("自由采购" + i);
            entity.setMaterielType("车间物料" + i);
            entity.setMaterielnum("X01CJ142");
            entity.setMaterielName("402PP线" + i);
            entity.setMaterielSpecifi("165CM*140g");
            entity.setOrderQuantity("34");
            entity.setInWarehouseNumCurrent("44");
            entity.setInWarehouseNumTotal("44");
            entity.setAuditStatus("已审核" + i);
            list.add(entity);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                OverAuditingAdapter adapter = new OverAuditingAdapter(OverAuditingListActivity.this, list);
                SlideInBottomAnimationAdapter slideAdapter = new SlideInBottomAnimationAdapter(adapter);
                slideAdapter.setDuration(800);
                mRecyclerView.setAdapter(slideAdapter);
                swipeRefreshLayout.setRefreshing(false);
            }
        },1000);

    }

}
