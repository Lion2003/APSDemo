package com.yiaosi.aps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yiaosi.aps.R;
import com.yiaosi.aps.entity.ProOrderArriveFormEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-06-09.
 */

public class ProOrderArriveFormAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ProOrderArriveFormEntity> list;
    private LayoutInflater mLayoutInflater;

    public ProOrderArriveFormAdapter(Context context, List<ProOrderArriveFormEntity> list) {
        this.context = context;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProOrderActivityFormViewHolder(mLayoutInflater.inflate(R.layout.item_prodorder_arrive_form, parent, false));
    }

    //onBindViewHolder专门用来绑定ViewHolder里的控件he数据源中positin位置的数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ProOrderActivityFormViewHolder)holder).produceOrderNum.setText("生产单号：" + list.get(position).getProduceOrderNum());
        ((ProOrderActivityFormViewHolder)holder).deliveryDate.setText("交货期：" + list.get(position).getDeliveryDate());
        ((ProOrderActivityFormViewHolder)holder).dakuan.setText("大款：" + list.get(position).getDakuan());
        ((ProOrderActivityFormViewHolder)holder).styleNum.setText("款号：" + list.get(position).getStyleNum());
        ((ProOrderActivityFormViewHolder)holder).num.setText("数量：" + list.get(position).getNum());
    }

    @Override
    public int getItemCount() {
        return (list == null) ? 0 : list.size();
    }

    public class ProOrderActivityFormViewHolder extends RecyclerView.ViewHolder {
        TextView produceOrderNum;  //生产单号
        TextView deliveryDate;  //交货期
        TextView dakuan;  //大款
        TextView styleNum;  //款号
        TextView num;  //数量

        public ProOrderActivityFormViewHolder(View itemView) {
            super(itemView);
            produceOrderNum = (TextView) itemView.findViewById(R.id.ipaf_produceOrderNum);  //生产单号
            deliveryDate = (TextView) itemView.findViewById(R.id.ipaf_deliveryDate);  //交货期
            dakuan = (TextView) itemView.findViewById(R.id.ipaf_styleNum);  //大款
            styleNum = (TextView) itemView.findViewById(R.id.ipaf_dakuan);  //款号
            num = (TextView) itemView.findViewById(R.id.ipaf_num);  //数量
        }
    }
}
