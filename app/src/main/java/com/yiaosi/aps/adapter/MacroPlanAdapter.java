package com.yiaosi.aps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yiaosi.aps.R;
import com.yiaosi.aps.entity.MacroPlanEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-09-06.
 */

public class MacroPlanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private Context context;
    private List<MacroPlanEntity> list;

    public MacroPlanAdapter(Context context, List<MacroPlanEntity> list) {
        this.context = context;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MacroPlanViewHolder(mLayoutInflater.inflate(R.layout.item_macro_plan, parent, false));
    }

    //onBindViewHolder专门用来绑定ViewHolder里的控件he数据源中positin位置的数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MacroPlanViewHolder)holder).img.setImageResource(list.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return (list == null) ? 0 : list.size();
    }

    public class MacroPlanViewHolder extends RecyclerView.ViewHolder {
        ImageView img; //图片

        public MacroPlanViewHolder(View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.imp_img); //图片
        }
    }

}
