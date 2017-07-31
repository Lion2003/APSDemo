package com.yiaosi.aps.ui;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.hyphenate.chatuidemo.db.UserDao;
import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.hyphenate.easeui.domain.EaseUser;
import com.yiaosi.aps.R;
import com.yiaosi.aps.adapter.OverAuditingAdapter;
import com.yiaosi.aps.adapter.RemindNoticeDetailAdapter;
import com.yiaosi.aps.entity.OverAuditingEntity;
import com.yiaosi.aps.entity.RemindNoticeDetailEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;

/**
 * Created by lenovo on 2017/7/24.
 */

public class RemindNoticeDetailActivity extends BaseActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private List<RemindNoticeDetailEntity> list;

    private ListView popListView;
    private List<Map<String, String>> statusData1;
    private PopupWindow popMenu;
    private SimpleAdapter menuAdapter1;
    private LinearLayout product, product1, product2;
    private TextView tvStatus, tvStatus1, tvStatus2;

    private int position = 0;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_remind_notice_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("详情");
        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.mipmap);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.arnd_swipe);
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


        initView();

        initData();

        UserDao dao = new UserDao(this);
        Map<String, EaseUser> kk = dao.getContactList();
        Log.e("sad", kk.toString());
    }

    private void initView() {
        product = (LinearLayout) findViewById(R.id.supplier_list_activity);
        tvStatus = (TextView) findViewById(R.id.supplier_list_activity_tv);
        product1 = (LinearLayout) findViewById(R.id.supplier_list_activity1);
        tvStatus1 = (TextView) findViewById(R.id.supplier_list_activity_tv1);
        product2 = (LinearLayout) findViewById(R.id.supplier_list_activity2);
        tvStatus2 = (TextView) findViewById(R.id.supplier_list_activity_tv2);

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 0;
                initPopMenu();

                tvStatus.setTextColor(Color.parseColor("#39ac69"));
                popListView.setAdapter(menuAdapter1);
                popMenu.showAsDropDown(product, 0, 2);
            }
        });
        product1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 1;
                initPopMenu();

                tvStatus1.setTextColor(Color.parseColor("#39ac69"));
                popListView.setAdapter(menuAdapter1);
                popMenu.showAsDropDown(product1, 0, 2);
            }
        });
        product2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 2;
                initPopMenu();

                tvStatus2.setTextColor(Color.parseColor("#39ac69"));
                popListView.setAdapter(menuAdapter1);
                popMenu.showAsDropDown(product2, 0, 2);
            }
        });
    }

    private void initMenuData() {
        statusData1 = new ArrayList<Map<String, String>>();
        String[] menuStr1 = new String[] { "全部", "润兴", "瑞亨", "凯信"};
        String[] menuStr2 = new String[] { "全部", "01车间", "02车间", "03车间"};
        String[] menuStr3 = new String[] { "全部", "A1", "A2", "A3"};
        Map<String, String> map1;
        switch(position) {
            case 0:
                for (int i = 0, len = menuStr1.length; i < len; ++i) {
                    map1 = new HashMap<String, String>();
                    map1.put("name", menuStr1[i]);
                    statusData1.add(map1);
                }
                break;
            case 1:
                for (int i = 0, len = menuStr2.length; i < len; ++i) {
                    map1 = new HashMap<String, String>();
                    map1.put("name", menuStr2[i]);
                    statusData1.add(map1);
                }
                break;
            case 2:
                for (int i = 0, len = menuStr3.length; i < len; ++i) {
                    map1 = new HashMap<String, String>();
                    map1.put("name", menuStr3[i]);
                    statusData1.add(map1);
                }
                break;
        }
    }

    private void initPopMenu() {
        initMenuData();
        View contentView = View.inflate(this, R.layout.popwin_supplier_list,
                null);
        popMenu = new PopupWindow(contentView,
                product.getWidth(), LinearLayout.LayoutParams.WRAP_CONTENT);
        popMenu.setOutsideTouchable(true);
        popMenu.setBackgroundDrawable(new BitmapDrawable());
        popMenu.setFocusable(true);
        popMenu.setAnimationStyle(R.style.popwin_anim_style);
        popMenu.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                switch(position) {
                    case 0:
                        tvStatus.setTextColor(Color.parseColor("#5a5959"));
                        break;
                    case 1:
                        tvStatus1.setTextColor(Color.parseColor("#5a5959"));
                        break;
                    case 2:
                        tvStatus2.setTextColor(Color.parseColor("#5a5959"));
                        break;
                }
            }
        });

        popListView = (ListView) contentView.findViewById(R.id.popwin_supplier_list_lv);
        contentView.findViewById(R.id.popwin_supplier_list_bottom)
                .setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        popMenu.dismiss();
                    }
                });
        menuAdapter1 = new SimpleAdapter(this, statusData1,
                R.layout.item_listview_popwin, new String[] { "name" },
                new int[] { R.id.listview_popwind_tv });

        popListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
                                    long arg3) {
                popMenu.dismiss();
                switch(position) {
                    case 0:
                        tvStatus.setText(statusData1.get(pos).get("name"));
                        break;
                    case 1:
                        tvStatus1.setText(statusData1.get(pos).get("name"));
                        break;
                    case 2:
                        tvStatus2.setText(statusData1.get(pos).get("name"));
                        break;
                }
            }
        });
    }

    private void initData() {
        list = new ArrayList<RemindNoticeDetailEntity>();
        RemindNoticeDetailEntity entity;
        for (int i = 0; i < 40; i++) {
            entity = new RemindNoticeDetailEntity();
            entity.setClientName("英氏");
            entity.setPicture("");
            entity.setProductionOrderNum("143013-035");
            entity.setProductionCount("700");
            entity.setClientStyleNum("CBKJ008");
            entity.setClientDeliveryTime("2017-01-05");
            entity.setAcutralProcess("68%");
            entity.setBackWardProcess("32%");
            list.add(entity);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                RemindNoticeDetailAdapter adapter = new RemindNoticeDetailAdapter(RemindNoticeDetailActivity.this, list);
                SlideInBottomAnimationAdapter slideAdapter = new SlideInBottomAnimationAdapter(adapter);
                slideAdapter.setDuration(800);
                mRecyclerView.setAdapter(slideAdapter);
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 1000);

    }
}