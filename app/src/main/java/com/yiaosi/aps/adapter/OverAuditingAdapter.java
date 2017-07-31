package com.yiaosi.aps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yiaosi.aps.R;
import com.yiaosi.aps.entity.OverAuditingEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-06-08.
 */

public class OverAuditingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private Context context;
    private List<OverAuditingEntity> list;

    public OverAuditingAdapter(Context context, List<OverAuditingEntity> list) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OverAuditingViewHolder(mLayoutInflater.inflate(R.layout.item_overaudit, parent, false));
    }

    /**
     * onBindViewHolder专门用来绑定ViewHolder里的控件he数据源中positin位置的数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((OverAuditingViewHolder)holder).orderNum.setText("单号：" + list.get(position).getOrderNum());
        ((OverAuditingViewHolder)holder).type.setText("类型：" + list.get(position).getType());
        ((OverAuditingViewHolder)holder).materielType.setText("物料类型：" + list.get(position).getMaterielType());
        ((OverAuditingViewHolder)holder).materielnum.setText("物料编号：" + list.get(position).getMaterielnum());
        ((OverAuditingViewHolder)holder).materielName.setText("物料名称：" + list.get(position).getMaterielName());
        ((OverAuditingViewHolder)holder).materielSpecifi.setText("物料规格：" + list.get(position).getMaterielSpecifi());
        ((OverAuditingViewHolder)holder).OrderQuantity.setText("订货数量：" + list.get(position).getOrderQuantity());
        ((OverAuditingViewHolder)holder).InWarehouseNumCurrent.setText("现入仓数：" + list.get(position).getInWarehouseNumCurrent());
        ((OverAuditingViewHolder)holder).InWarehouseNumTotal.setText("总入仓数：" + list.get(position).getInWarehouseNumTotal());
        ((OverAuditingViewHolder)holder).auditStatus.setText("审核状态：" + list.get(position).getAuditStatus());
    }

    @Override
    public int getItemCount() {
        return (list.size() == 0) ? 0 : list.size();
    }

    public class OverAuditingViewHolder extends RecyclerView.ViewHolder {
        TextView orderNum;
        TextView type;
        TextView materielType;
        TextView materielnum;
        TextView materielName;
        TextView materielSpecifi;
        TextView OrderQuantity;
        TextView InWarehouseNumCurrent;
        TextView InWarehouseNumTotal;
        TextView auditStatus;

        public OverAuditingViewHolder(View itemView) {
            super(itemView);
            orderNum = (TextView) itemView.findViewById(R.id.io_orderNum);
            type = (TextView) itemView.findViewById(R.id.io_type);
            materielType = (TextView) itemView.findViewById(R.id.io_materelType);
            materielnum = (TextView) itemView.findViewById(R.id.io_materielNum);
            materielName = (TextView) itemView.findViewById(R.id.io_materelName);
            materielSpecifi = (TextView) itemView.findViewById(R.id.io_materielSpecifi);
            OrderQuantity = (TextView) itemView.findViewById(R.id.io_OrderQuantity);
            InWarehouseNumCurrent = (TextView) itemView.findViewById(R.id.io_InWarehouseNumCurrent);
            InWarehouseNumTotal = (TextView) itemView.findViewById(R.id.io_InWarehouseNumTotal);
            auditStatus = (TextView) itemView.findViewById(R.id.io_auditStatus);
        }
    }

}
