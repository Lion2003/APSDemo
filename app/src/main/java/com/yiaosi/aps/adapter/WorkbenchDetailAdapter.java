package com.yiaosi.aps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
    private String isShow;

    public WorkbenchDetailAdapter(Context context, String isShow) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.isShow = isShow;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Item3ViewHolder(mLayoutInflater.inflate(R.layout.item_work_bench_detail, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Item3ViewHolder)holder).edit.clearFocus();
        if (isShow.equals("0")) {

        } else if(isShow.equals("1")) {
            ((Item3ViewHolder)holder).tv.setText("处理结果      已处理");
            ((Item3ViewHolder)holder).btn.setVisibility(View.GONE);
            ((Item3ViewHolder)holder).layout.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class Item3ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private Button btn;
        private RelativeLayout layout;
        private EditText edit;

        public Item3ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            btn = (Button) itemView.findViewById(R.id.eal_btnLogin);
            layout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
            edit = (EditText) itemView.findViewById(R.id.ed);
        }
    }
}
