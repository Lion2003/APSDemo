package com.yiaosi.aps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yiaosi.aps.R;
import com.yiaosi.aps.entity.RemindNoticeDetailEntity;

import java.util.List;

/**
 * Created by lenovo on 2017/7/24.
 */

public class RemindNoticeDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private Context context;
    private List<RemindNoticeDetailEntity> list;

    public RemindNoticeDetailAdapter(Context context, List<RemindNoticeDetailEntity> list) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RemindNoticeViewHolder(mLayoutInflater.inflate(R.layout.item_remind_notice_detail, parent, false));
    }

    /**
     * onBindViewHolder专门用来绑定ViewHolder里的控件he数据源中positin位置的数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position == 0) {
            ((RemindNoticeViewHolder) holder).view.setVisibility(View.VISIBLE);
        } else {
            ((RemindNoticeViewHolder) holder).view.setVisibility(View.GONE);
        }
        ((RemindNoticeViewHolder) holder).clientName.setText("客户名称 " + list.get(position).getClientName());
//        ((RemindNoticeViewHolder) holder).picture
        Glide.with(context).load(list.get(position).getPicture())
                .into(((RemindNoticeViewHolder) holder).picture);
        ((RemindNoticeViewHolder) holder).productionOrderNum.setText("生产单号 " + list.get(position).getProductionOrderNum());
        ((RemindNoticeViewHolder) holder).productionCount.setText("生产数量 " + list.get(position).getProductionCount());
        ((RemindNoticeViewHolder) holder).clientStyleNum.setText("客户款号 " + list.get(position).getClientStyleNum());
        ((RemindNoticeViewHolder) holder).clientDeliveryTime.setText("客户交期 " + list.get(position).getClientDeliveryTime());
//        ((RemindNoticeViewHolder) holder).acutralProcess.setText("实际进度 " + list.get(position).getAcutralProcess()
//                + "  " + "进度落后 " + list.get(position).getBackWardProcess());
        ((RemindNoticeViewHolder) holder).acutralProcess.setText(Html.fromHtml(context.getResources().getString(R.string.integrallimit_buy_num,
                list.get(position).getAcutralProcess(), list.get(position).getBackWardProcess())));
    }

    @Override
    public int getItemCount() {
        return (list.size() == 0) ? 0 : list.size();
    }

    public class RemindNoticeViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView clientName;  //客户名称
        ImageView picture;
        TextView productionOrderNum;  //生产单号
        TextView productionCount;  //生产单数
        TextView clientStyleNum;  //客户款号
        TextView clientDeliveryTime;  //客户交期
        TextView acutralProcess;  //实际进度
//        TextView backWardProcess;  //进度落后

        public RemindNoticeViewHolder(View itemView) {
            super(itemView);
            view = (View) itemView.findViewById(R.id.irnd_view);
            clientName = (TextView) itemView.findViewById(R.id.irnd_tvClientName);
            picture = (ImageView) itemView.findViewById(R.id.irnd_pic);
            productionOrderNum = (TextView) itemView.findViewById(R.id.irnd_productOrderNum);
            productionCount = (TextView) itemView.findViewById(R.id.irnd_productCount);
            clientStyleNum = (TextView) itemView.findViewById(R.id.irnd_clientStyleNum);
            clientDeliveryTime = (TextView) itemView.findViewById(R.id.irnd_clientDeliveryTime);
            acutralProcess = (TextView) itemView.findViewById(R.id.irnd_acutralProcess);
        }
    }
}