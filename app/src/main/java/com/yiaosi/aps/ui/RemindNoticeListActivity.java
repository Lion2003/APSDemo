package com.yiaosi.aps.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.yiaosi.aps.R;
import com.yiaosi.aps.adapter.RemindNoticeAdapter;
import com.yiaosi.aps.adapter.RemindNoticeViewPagerAdapter;
import com.yiaosi.aps.mvp.bean.RemindNoticeTypeEntity;
import com.yiaosi.aps.mvp.presenter.RemindNoticePresenter;
import com.yiaosi.aps.mvp.view.IRemindNoticeView;
import com.yiaosi.aps.widget.SpaceItemDecoration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;

/**
 * 提醒通知
 * Created by Administrator on 2017-06-19.
 */

public class RemindNoticeListActivity extends BaseActivity implements IRemindNoticeView {
    private TabLayout tablayout;
    private ViewPager viewPager;
//    private SwipeRefreshLayout swipeRefreshLayout;
//    private RecyclerView mRecyclerView;
    private RemindNoticePresenter remindNoticePresenter = new RemindNoticePresenter(this);

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_remind_notice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("任务提醒");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initView();
        remindNoticePresenter.getRemindNoticeList();
    }

    private void initView() {
        tablayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(4);

//        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.arn_swipe);
//        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
//
//        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_light,
//                android.R.color.holo_green_light);
////        swipeRefreshLayout.post(new Runnable() {
////            @Override
////            public void run() {
////                swipeRefreshLayout.setRefreshing(true);
////            }
////        });
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                swipeRefreshLayout.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        swipeRefreshLayout.setRefreshing(false);
//                    }
//                }, 1000);
//            }
//        });
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        mRecyclerView.setLayoutManager(layoutManager);
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new SpaceItemDecoration(2));
    }

    @Override
    public void showLoading() {
//        swipeRefreshLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                swipeRefreshLayout.setRefreshing(true);
//            }
//        });
    }

    @Override
    public void hideLoading() {
//        swipeRefreshLayout.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                swipeRefreshLayout.setRefreshing(false);
//            }
//        }, 1000);
    }

    @Override
    public void showList(String[] titles, List<RemindNoticeTypeEntity> list) {
        List<Fragment> fragmentList = new ArrayList<Fragment>();

        List<RemindNoticeTypeEntity> listNew1 = new ArrayList<RemindNoticeTypeEntity>();
        List<RemindNoticeTypeEntity> listNew2 = new ArrayList<RemindNoticeTypeEntity>();
        List<RemindNoticeTypeEntity> listNew3 = new ArrayList<RemindNoticeTypeEntity>();
        List<RemindNoticeTypeEntity> listNew4 = new ArrayList<RemindNoticeTypeEntity>();
        for(int i = 0; i < titles.length; i++) {
            tablayout.addTab(tablayout.newTab().setText(titles[i]));
        }
        for(int i = 0; i < list.size(); i++) {
            if(i < 5) {
                listNew1.add(list.get(i));
            } else if(i >= 5 && i < 8 ) {
                listNew2.add(list.get(i));
            } else if(i >=8 && i < 10) {
                listNew3.add(list.get(i));
            } else {
                listNew4.add(list.get(i));
            }
        }
        Fragment fragment1 = new RemindNoticeListFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putSerializable("list", (Serializable) listNew1);
        fragment1.setArguments(bundle1);
        fragmentList.add(fragment1);

        Fragment fragment2 = new RemindNoticeListFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("list", (Serializable) listNew2);
        fragment2.setArguments(bundle2);
        fragmentList.add(fragment2);

        Fragment fragment3 = new RemindNoticeListFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putSerializable("list", (Serializable) listNew3);
        fragment3.setArguments(bundle3);
        fragmentList.add(fragment3);

        Fragment fragment4 = new RemindNoticeListFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putSerializable("list", (Serializable) listNew4);
        fragment4.setArguments(bundle4);
        fragmentList.add(fragment4);

        RemindNoticeViewPagerAdapter adapter = new RemindNoticeViewPagerAdapter(getSupportFragmentManager(), titles, fragmentList);
        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabsFromPagerAdapter(adapter);

//        RemindNoticeAdapter adapter = new RemindNoticeAdapter(this, list);
//        SlideInBottomAnimationAdapter slideAdapter = new SlideInBottomAnimationAdapter(adapter);
//        slideAdapter.setDuration(800);
//        mRecyclerView.setAdapter(slideAdapter);
//
//        adapter.setOnMyClickListener(new RemindNoticeAdapter.OnMyClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(RemindNoticeListActivity.this, view.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
