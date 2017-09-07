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
//        RemindNoticeDetailEntity entity;
//        for (int i = 0; i < 40; i++) {
//            entity = new RemindNoticeDetailEntity();
//            entity.setClientName("英氏");
//            entity.setPicture("");
//            entity.setProductionOrderNum("143013-035");
//            entity.setProductionCount("700");
//            entity.setClientStyleNum("CBKJ008");
//            entity.setClientDeliveryTime("2017-01-05");
//            entity.setAcutralProcess("68%");
//            entity.setBackWardProcess("32%");
//            list.add(entity);
//        }


        RemindNoticeDetailEntity entity = new RemindNoticeDetailEntity();
        entity.setClientName("英氏");
        entity.setPicture("http://img0.imgtn.bdimg.com/it/u=3671850754,3508119930&fm=26&gp=0.jpg");
        entity.setProductionOrderNum("143013-035");
        entity.setProductionCount("700");
        entity.setClientStyleNum("CBKJ008");
        entity.setClientDeliveryTime("2017-01-05");
        entity.setAcutralProcess("68%");
        entity.setBackWardProcess("32%");
        list.add(entity);

        RemindNoticeDetailEntity entity1 = new RemindNoticeDetailEntity();
        entity1.setClientName("凯信");
        entity1.setPicture("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505294194&di=9dda17ff2babca4789bf019a97fed4ce&imgtype=jpg&er=1&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F12%2F26%2F80%2F65U58PICmgS.jpg");
        entity1.setProductionOrderNum("143026-036");
        entity1.setProductionCount("1500");
        entity1.setClientStyleNum("CBKJ009");
        entity1.setClientDeliveryTime("2017-01-23");
        entity1.setAcutralProcess("70%");
        entity1.setBackWardProcess("30%");
        list.add(entity1);

        RemindNoticeDetailEntity entity2 = new RemindNoticeDetailEntity();
        entity2.setClientName("瑞亨");
        entity2.setPicture("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505294405&di=abd83b495d44cb6bf5ece6e42cc5bd0b&imgtype=jpg&er=1&src=http%3A%2F%2Fec4.images-amazon.com%2Fimages%2FI%2F81m85A-AhCL._UL1500_.jpg");
        entity2.setProductionOrderNum("144028-040");
        entity2.setProductionCount("1820");
        entity2.setClientStyleNum("CBKJ110");
        entity2.setClientDeliveryTime("2017-02-18");
        entity2.setAcutralProcess("73%");
        entity2.setBackWardProcess("27%");
        list.add(entity2);

        RemindNoticeDetailEntity entity3 = new RemindNoticeDetailEntity();
        entity3.setClientName("衣联");
        entity3.setPicture("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505294611&di=796ec70977692f216801eea14158ff78&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F016f02577cd4080000018c1bb073dd.jpg%40900w_1l_2o_100sh.jpg");
        entity3.setProductionOrderNum("145032-047");
        entity3.setProductionCount("2620");
        entity3.setClientStyleNum("CBKK720");
        entity3.setClientDeliveryTime("2017-03-19");
        entity3.setAcutralProcess("75%");
        entity3.setBackWardProcess("25%");
        list.add(entity3);

        RemindNoticeDetailEntity entity4 = new RemindNoticeDetailEntity();
        entity4.setClientName("品好尚");
        entity4.setPicture("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505294647&di=06ba5af856f06696a97cc2670c102e32&imgtype=jpg&er=1&src=http%3A%2F%2Fimg001.hc360.cn%2Fm3%2FM07%2F05%2F03%2FwKhQ51SaLTuEe2HHAAAAAOAIbjU899.jpg");
        entity4.setProductionOrderNum("146011-050");
        entity4.setProductionCount("2730");
        entity4.setClientStyleNum("CBKK721");
        entity4.setClientDeliveryTime("2017-04-09");
        entity4.setAcutralProcess("77%");
        entity4.setBackWardProcess("23%");
        list.add(entity4);

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