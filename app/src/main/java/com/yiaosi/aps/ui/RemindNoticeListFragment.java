package com.yiaosi.aps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yiaosi.aps.R;
import com.yiaosi.aps.adapter.RemindNoticeAdapter;
import com.yiaosi.aps.mvp.bean.RemindNoticeTypeEntity;
import com.yiaosi.aps.tool.DividerItemDecoration;

import java.util.List;

import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;

/**
 * Created by Administrator on 2017-07-20.
 */

public class RemindNoticeListFragment extends Fragment {
    private View view;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager layoutManager;
    private List<RemindNoticeTypeEntity> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_remind_notice, container, false);
        list = (List<RemindNoticeTypeEntity>) getArguments().getSerializable("list");
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));


        RemindNoticeAdapter adapter = new RemindNoticeAdapter(getActivity(), list);
        SlideInBottomAnimationAdapter slideAdapter = new SlideInBottomAnimationAdapter(adapter);
        slideAdapter.setDuration(800);
        mRecyclerView.setAdapter(slideAdapter);

        adapter.setOnMyClickListener(new RemindNoticeAdapter.OnMyClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), RemindNoticeDetailActivity.class);
                startActivity(it);
            }
        });

        return view;
    }



















}
