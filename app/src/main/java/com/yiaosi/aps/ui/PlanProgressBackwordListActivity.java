package com.yiaosi.aps.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.yiaosi.aps.R;
import com.yiaosi.aps.mvp.bean.PlanProgressEntity;
import com.yiaosi.aps.mvp.presenter.PlanProgressPresenter;
import com.yiaosi.aps.mvp.view.IPlanProgressView;
import com.yiaosi.aps.widget.SpaceItemDecoration;

import java.util.List;

/**
 * Created by Administrator on 2017-06-19.
 */

public class PlanProgressBackwordListActivity extends BaseActivity implements IPlanProgressView {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private PlanProgressPresenter planProgressPresenter = new PlanProgressPresenter(this);

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_planprogressbackword);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("计划进度落后");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initView();

        planProgressPresenter.getPlanProgressList();
    }

    private void initView() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.ap_swipe);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);

        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_light,
                android.R.color.holo_green_light);

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

    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 1000);
    }

    @Override
    public void showList(List<PlanProgressEntity> list) {
//        RemindNoticeAdapter adapter = new RemindNoticeAdapter(this, list);
//        SlideInBottomAnimationAdapter slideAdapter = new SlideInBottomAnimationAdapter(adapter);
//        slideAdapter.setDuration(800);
//        mRecyclerView.setAdapter(slideAdapter);
//
//        adapter.setOnMyClickListener(new RemindNoticeAdapter.OnMyClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(PlanProgressBackwordListActivity.this, view.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
