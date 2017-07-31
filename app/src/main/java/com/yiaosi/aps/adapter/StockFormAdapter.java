package com.yiaosi.aps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yiaosi.aps.R;
import com.yiaosi.aps.entity.StockFormEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-06-09.
 */

public class StockFormAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private Context context;
    private List<StockFormEntity> list;

    public StockFormAdapter(Context context, List<StockFormEntity> list) {
        this.context = context;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StockFormViewHolder(mLayoutInflater.inflate(R.layout.item_stock_form, parent, false));
    }

    //onBindViewHolder专门用来绑定ViewHolder里的控件he数据源中positin位置的数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((StockFormViewHolder)holder).clientName.setText("客户名称：" + list.get(position).getClientName());
        ((StockFormViewHolder)holder).dakuanName.setText("大款名称：" + list.get(position).getDakuanName());
        ((StockFormViewHolder)holder).materielType.setText("物料类型：" + list.get(position).getMaterielType());
        ((StockFormViewHolder)holder).materielName.setText("物料名称：" + list.get(position).getMaterielName());
        ((StockFormViewHolder)holder).color.setText("颜色：" + list.get(position).getColor());
        ((StockFormViewHolder)holder).specifi.setText("规格：" + list.get(position).getSpecifi());
        ((StockFormViewHolder)holder).colorNum.setText("色号：" + list.get(position).getColorNum());
        ((StockFormViewHolder)holder).beginPeriodNum.setText("期初数：" + list.get(position).getBeginPeriodNum());
        ((StockFormViewHolder)holder).inStorageNum.setText("入库数：" + list.get(position).getInStorageNum());
        ((StockFormViewHolder)holder).outStorageNum.setText("出库数：" + list.get(position).getOutStorageNum());
        ((StockFormViewHolder)holder).balanceNum.setText("结存数：" + list.get(position).getBalanceNum());
        ((StockFormViewHolder)holder).producNumber.setText("生产单号：" + list.get(position).getProducNumber());
    }

    @Override
    public int getItemCount() {
        return (list == null) ? 0 : list.size();
    }

    public class StockFormViewHolder extends RecyclerView.ViewHolder {
         TextView clientName; //客户名称
         TextView dakuanName; //大款名称
         TextView materielType; //物料类型
         TextView materielName; //物料名称
         TextView color; //颜色
         TextView specifi; //规格
         TextView colorNum; //色号
         TextView beginPeriodNum; //期初数
         TextView inStorageNum; //入库数
         TextView outStorageNum; //出库数
         TextView balanceNum; //结存数
         TextView producNumber ; //生产单号

        public StockFormViewHolder(View itemView) {
            super(itemView);
            clientName = (TextView)itemView.findViewById(R.id.isf_clientName); //客户名称
            dakuanName = (TextView)itemView.findViewById(R.id.isf_dakuanName); //大款名称
            materielType = (TextView)itemView.findViewById(R.id.isf_materielType); //物料类型
            materielName = (TextView)itemView.findViewById(R.id.isf_materielName); //物料名称
            color = (TextView)itemView.findViewById(R.id.isf_color); //颜色
            specifi = (TextView)itemView.findViewById(R.id.isf_specifi); //规格
            colorNum = (TextView)itemView.findViewById(R.id.isf_colorNum); //色号
            beginPeriodNum = (TextView)itemView.findViewById(R.id.isf_beginPeriodNum); //期初数
            inStorageNum = (TextView)itemView.findViewById(R.id.isf_inStorageNum); //入库数
            outStorageNum = (TextView)itemView.findViewById(R.id.isf_outStorageNum); //出库数
            balanceNum = (TextView)itemView.findViewById(R.id.isf_balanceNum); //结存数
            producNumber = (TextView)itemView.findViewById(R.id.isf_producNumber) ; //生产单号
        }
    }

}
