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
 * Created by Administrator on 2017-06-05.
 */

public class WorkbenchItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TITLE = 0;
    private static final int ITEM1 = 1;
    private static final int ITEM2 = 2;
    private static final int ITEM3 = 3;
    private Context context;
    private List<WorkbenchItem> list;
    private LayoutInflater mLayoutInflater;
    private OnMyClickListener onMyClickListener;

    public WorkbenchItemAdapter(Context context, List<WorkbenchItem> list) {
        this.context = context;
        this.list = list;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public interface OnMyClickListener {
        void onClick(View view, int position, String pic, String isShow);
    }

    public void setOnMyClickListener(OnMyClickListener onMyClickListener) {
        this.onMyClickListener = onMyClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TITLE) {
            return new HeaderViewHolder(mLayoutInflater.inflate(R.layout.em_workbench_header, parent, false));
        } else if(viewType == ITEM1) {
            return new Item1ViewHolder(mLayoutInflater.inflate(R.layout.em_workbench_itemtype1, parent, false));
        } else if(viewType == ITEM2) {
            return new Item2ViewHolder(mLayoutInflater.inflate(R.layout.em_workbench_itemtype2, parent, false));
        } else if(viewType == ITEM3) {
            return new Item3ViewHolder(mLayoutInflater.inflate(R.layout.em_workbench_itemtype3, parent, false));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder)holder).item0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMyClickListener.onClick(v, 0, "", "-1");
                }
            });
            ((HeaderViewHolder)holder).item1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMyClickListener.onClick(v, 1, "", "-1");
                }
            });
            ((HeaderViewHolder)holder).item2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMyClickListener.onClick(v, 2, "", "-1");
                }
            });
            ((HeaderViewHolder)holder).item3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMyClickListener.onClick(v, 3, "", "-1");
                }
            });
        } else if( holder instanceof Item1ViewHolder) {
            if(position == 1) {
                ((Item1ViewHolder)holder).title.setText("今日紧急未处理单");
            } else if(position == getItemCount() - 2) {
                ((Item1ViewHolder)holder).title.setText("今日任务事项");
            }
        } else if(holder instanceof Item2ViewHolder) {
//            ((RemindNoticeAdapter.ItemViewHolder)holder).relativeLayout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onMyClickListener.onClick(v);
//                }
//            });

            ((Item2ViewHolder)holder).linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMyClickListener.onClick(v, 4, list.get(position - 2).getPic(), list.get(position - 2).getIsFinish());
                }
            });
            ((Item2ViewHolder)holder).customerName.setText("客户名称:" + list.get(position - 2).getCustomerName());
            if(list.get(position - 2).getIsFinish().equals("1")) {
                ((Item2ViewHolder)holder).jindu.setText("已处理");
                ((Item2ViewHolder)holder).jindu.setTextColor(context.getResources().getColor(R.color.color_808080));
            } else {
                ((Item2ViewHolder)holder).jindu.setText("未处理");
                ((Item2ViewHolder)holder).jindu.setTextColor(context.getResources().getColor(R.color.color_e24a4a));
            }
            Glide.with(context).load(list.get(position - 2).getPic()).into(((Item2ViewHolder)holder).img);
            ((Item2ViewHolder)holder).ewi_productOrderNum.setText(list.get(position - 2).getProductOrderNum());
            ((Item2ViewHolder)holder).ewi_clientDate.setText(list.get(position - 2).getCustomerDate());
            ((Item2ViewHolder)holder).ewi_styleNum.setText(list.get(position - 2).getStyleNum());
            ((Item2ViewHolder)holder).ewi_color.setText(list.get(position - 2).getColor());
            ((Item2ViewHolder)holder).ewi_number.setText("数量 " + list.get(position - 2).getNum());
        } else if(holder instanceof Item3ViewHolder) {

        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return TITLE;
        } else if(position == 1 || position == getItemCount() - 2) {
            return ITEM1;
        } else if(position == getItemCount() - 1) {
            return ITEM3;
        } else {
            return ITEM2;
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 4;
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout item0, item1, item2, item3;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            item0 = (LinearLayout) itemView.findViewById(R.id.ewh_item0);
            item1 = (LinearLayout) itemView.findViewById(R.id.ewh_item1);
            item2 = (LinearLayout) itemView.findViewById(R.id.ewh_item2);
            item3 = (LinearLayout) itemView.findViewById(R.id.ewh_item3);
        }
    }

    public class Item1ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;

        public Item1ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.ewi_title);
        }
    }

    public class Item2ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;
        private TextView customerName;
        private ImageView img;
        private TextView ewi_productOrderNum;
        private TextView ewi_clientDate;
        private TextView ewi_styleNum;
        private TextView ewi_color;
        private TextView ewi_number;
        private TextView jindu;

        public Item2ViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.ewi_LinearLayout);
            customerName = (TextView) itemView.findViewById(R.id.ewi_tvClientName);
            img = (ImageView) itemView.findViewById(R.id.ewi_pic);
            jindu = (TextView) itemView.findViewById(R.id.jindu);
            ewi_productOrderNum = (TextView) itemView.findViewById(R.id.ewi_productOrderNum);
            ewi_clientDate = (TextView) itemView.findViewById(R.id.ewi_clientDate);
            ewi_styleNum = (TextView) itemView.findViewById(R.id.ewi_styleNum);
            ewi_color = (TextView) itemView.findViewById(R.id.ewi_color);
            ewi_number = (TextView) itemView.findViewById(R.id.ewi_number);
        }
    }

    public class Item3ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        private TextView tv4;
        private TextView tv5;

        public Item3ViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.ewi_1);
            tv2 = (TextView) itemView.findViewById(R.id.ewi_2);
            tv3 = (TextView) itemView.findViewById(R.id.ewi_3);
            tv4 = (TextView) itemView.findViewById(R.id.ewi_4);
            tv5 = (TextView) itemView.findViewById(R.id.ewi_5);
        }
    }
}
