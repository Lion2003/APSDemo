package com.yiaosi.aps.entity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.yiaosi.aps.R;

import java.util.List;

/**
 * Created by Administrator on 2017-07-21.
 */

public class OutSourcingFactoryManagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private Context context;
    private List<OutSourcingFactoryEntity> list;

    private setOnClick onClick;

    public OutSourcingFactoryManagerAdapter(Context context, List<OutSourcingFactoryEntity> list) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.list = list;
    }

    public interface setOnClick{
        void onClick();
    }

    public void setOnItemClickListener(setOnClick onClick) {
        this.onClick = onClick;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FactoryViewHolder(mLayoutInflater.inflate(R.layout.item_outsourcfactory, parent, false));
    }

    /**
     * onBindViewHolder专门用来绑定ViewHolder里的控件he数据源中positin位置的数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((FactoryViewHolder)holder).productOrderNum.setText("生产单号：" + list.get(position).getProductOrderNum());
        ((FactoryViewHolder)holder).productionLine.setText(list.get(position).getProductionLine());
        ((FactoryViewHolder)holder).styleNum.setText(list.get(position).getStyleNum());
        ((FactoryViewHolder)holder).beginDate.setText(list.get(position).getBeginDate());
        ((FactoryViewHolder)holder).totalCount.setText(list.get(position).getTotalCount());
        ((FactoryViewHolder)holder).workShopDeliveryTime.setText(list.get(position).getWorkShopDeliveryTime());
        ((FactoryViewHolder)holder).specifications.setText(list.get(position).getSpecifications());
        ((FactoryViewHolder)holder).endDate.setText(list.get(position).getEndDate());
        ((FactoryViewHolder)holder).completedNum.setText(list.get(position).getCompletedNum());
        ((FactoryViewHolder)holder).btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (list.size() == 0) ? 0 : list.size();
    }

    public class FactoryViewHolder extends RecyclerView.ViewHolder {
        TextView productOrderNum; //生产单号
        TextView productionLine; //生产线
        TextView styleNum; //款号
        TextView beginDate; //开始日期
        TextView totalCount; //总数量
        TextView workShopDeliveryTime; //车间交期
        TextView specifications; //规格
        TextView endDate; //结束日期
        TextView completedNum; //已完成数
        Button btn;

        public FactoryViewHolder(View itemView) {
            super(itemView);
            productOrderNum = (TextView) itemView.findViewById(R.id.io_productionNum);
            productionLine = (TextView) itemView.findViewById(R.id.io_productionLine);
            styleNum = (TextView) itemView.findViewById(R.id.io_styleNum);
            beginDate = (TextView) itemView.findViewById(R.id.io_beingDate);
            totalCount = (TextView) itemView.findViewById(R.id.io_totalCount);
            workShopDeliveryTime = (TextView) itemView.findViewById(R.id.io_workShopDeliveryTime);
            specifications = (TextView) itemView.findViewById(R.id.io_specifications);
            endDate = (TextView) itemView.findViewById(R.id.io_endDate);
            completedNum = (TextView) itemView.findViewById(R.id.io_completeNum);
            btn = (Button) itemView.findViewById(R.id.io_btn);
        }
    }
}
