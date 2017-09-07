package com.yiaosi.aps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hyphenate.easeui.ui.EaseBaseFragment;
import com.yiaosi.aps.R;
import com.yiaosi.aps.adapter.RemindNoticeAdapter;
import com.yiaosi.aps.adapter.WorkbenchItemAdapter;
import com.yiaosi.aps.entity.WorkbenchItem;
import com.yiaosi.aps.widget.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;

/**
 * Created by Administrator on 2017-06-02.
 */
public class WorkbenchFragment extends EaseBaseFragment {
    private View view;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.em_fragment_workbench, container, false);
        return view;
    }

    @Override
    protected void initView() {
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.efw_swipe);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);

        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_light,
                android.R.color.holo_green_light);
//        swipeRefreshLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                swipeRefreshLayout.setRefreshing(true);
//            }
//        });
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

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new SpaceItemDecoration(10));
    }

    @Override
    protected void setUpView() {
        List<WorkbenchItem> list = initData();

        WorkbenchItemAdapter adapter = new WorkbenchItemAdapter(getActivity(), list);
        SlideInBottomAnimationAdapter slideAdapter = new SlideInBottomAnimationAdapter(adapter);
        slideAdapter.setDuration(800);
        mRecyclerView.setAdapter(slideAdapter);

        adapter.setOnMyClickListener(new WorkbenchItemAdapter.OnMyClickListener() {
            @Override
            public void onClick(View view, int position, String pic) {
                switch (position) {
                    case 0:
                        Intent it0 = new Intent(getActivity(), MacroPlanActivity.class);
                        startActivity(it0);
                        break;
                    case 1:
                        Intent it1 = new Intent(getActivity(), OutSourcingFactoryManagerActivity.class);
                        startActivity(it1);
                        break;
                    case 2:
                        Intent it2 = new Intent(getActivity(), RemindNoticeListActivity.class);
                        startActivity(it2);
                        break;
                    case 3:
                        Intent it3 = new Intent(getActivity(), AllFunctionActivity.class);
                        startActivity(it3);
                        break;
                    case 4:
                        Intent it4 = new Intent(getActivity(), WorkbenchDetailActivity.class);
                        it4.putExtra("pic", pic);
                        startActivity(it4);
                        break;
                }
            }
        });

        listener();
    }

    /**
     * 硬编码，获取数据
     * @return
     */
    private List<WorkbenchItem> initData() {
//        List<WorkbenchItem> list = new ArrayList<WorkbenchItem>();
//        String[] name = {"宏观计划", "超量审核", "库存报表", "生产到货报表", "生产排程报表", "日产量产值", "完结单报表", "全部..."};
//        int[] imgResource = {R.drawable.ease_chat_image_normal, R.drawable.em_chat_file_normal, R.drawable.em_chat_video_call_normal,
//                              R.drawable.em_chat_video_normal, R.drawable.em_chat_voice_call_normal, R.drawable.ease_chat_location_normal,
//                              R.drawable.ease_chat_takepic_normal, R.drawable.em_new_friends_icon};
//        WorkbenchItem item = null;
//        for(int i = 0; i < 8; i++) {
//            item = new WorkbenchItem();
//            item.setImgResource(imgResource[i]);
//            item.setName(name[i]);
//            list.add(item);
//        }
//        return list;

        //测试数据
        List<WorkbenchItem> list = new ArrayList<WorkbenchItem>();
        WorkbenchItem item1 = new WorkbenchItem();
        item1.setColor("蓝色");
        item1.setCustomerDate("2017-08-06");
        item1.setCustomerName("路易雪莱");
        item1.setNum("5700件");
        item1.setPic("http://img0.imgtn.bdimg.com/it/u=1964021779,3552663795&fm=26&gp=0.jpg");
        item1.setProductOrderNum("1317403280");
        item1.setStyleNum("百灵D2887长裤");
        item1.setIsFinish("0");
        list.add(item1);

        WorkbenchItem item2 = new WorkbenchItem();
        item2.setColor("黑色");
        item2.setCustomerDate("2017-08-06");
        item2.setCustomerName("博斯绅威");
        item2.setNum("12700件");
        item2.setPic("http://img2.imgtn.bdimg.com/it/u=1006220908,600853774&fm=26&gp=0.jpg");
        item2.setProductOrderNum("174C1C5746721");
        item2.setStyleNum("休闲长裤");
        item2.setIsFinish("1");
        list.add(item2);

        WorkbenchItem item3 = new WorkbenchItem();
        item3.setColor("黑色");
        item3.setCustomerDate("2017-08-27");
        item3.setCustomerName("迪丰");
        item3.setNum("5000件");
        item3.setPic("http://img4.imgtn.bdimg.com/it/u=2674232278,2217854416&fm=26&gp=0.jpg");
        item3.setProductOrderNum("080773350");
        item3.setStyleNum("百灵西裤");
        item3.setIsFinish("0");
        list.add(item3);

        return list;
    }

    private void listener() {
//        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch(position) {
//                    case 0:
//                        Intent it0 = new Intent(getActivity(), MacroPlanActivity.class);
//                        startActivity(it0);
//                        break;
//                    case 1:
//                        Intent it1 = new Intent(getActivity(), OverAuditingSearchActivity.class);
//                        startActivity(it1);
//                         break;
//                    case 2:
//                        Intent it2 = new Intent(getActivity(), StockFormSearchActivity.class);
//                        startActivity(it2);
//                         break;
//                    case 3:
//                        Intent it3 = new Intent(getActivity(), ProOrderArriveFormSearchActivity.class);
//                        startActivity(it3);
//                        break;
//                    case 4:
//                        Toast.makeText(getActivity(), "正在开发中", Toast.LENGTH_SHORT).show();
//                        break;
//                    case 5:
//                        Toast.makeText(getActivity(), "正在开发中", Toast.LENGTH_SHORT).show();
//                        break;
//                    case 6:
//                        Toast.makeText(getActivity(), "正在开发中", Toast.LENGTH_SHORT).show();
//                        break;
//                    case 7:
//                        Toast.makeText(getActivity(), "正在开发中", Toast.LENGTH_SHORT).show();
//                        break;
//
//                }
//            }
//        });
//
//        btnRemindNotice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent it = new Intent(getActivity(), RemindNoticeListActivity.class);
//                startActivity(it);
//            }
//        });
    }

}
