package com.yiaosi.aps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yiaosi.aps.R;
import com.yiaosi.aps.entity.WorkbenchItem;

import java.util.List;

/**
 * Created by Administrator on 2017-07-25.
 */

public class WorkbenchDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater mLayoutInflater;

    public WorkbenchDetailAdapter(Context context) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Item3ViewHolder(mLayoutInflater.inflate(R.layout.item_work_bench_detail, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class Item3ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        private TextView tv4;
        private TextView tv5;

        public Item3ViewHolder(View itemView) {
            super(itemView);
//            tv1 = (TextView) itemView.findViewById(R.id.ewi_1);
//            tv2 = (TextView) itemView.findViewById(R.id.ewi_2);
//            tv3 = (TextView) itemView.findViewById(R.id.ewi_3);
//            tv4 = (TextView) itemView.findViewById(R.id.ewi_4);
//            tv5 = (TextView) itemView.findViewById(R.id.ewi_5);
        }
    }
}
