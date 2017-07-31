package com.yiaosi.aps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yiaosi.aps.R;
import com.yiaosi.aps.mvp.bean.RemindNoticeTypeEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-06-19.
 */

public class RemindNoticeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//    private static final int TITLE = 1;
//    private static final int ITEM = 2;
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<RemindNoticeTypeEntity> list;
    private OnMyClickListener onMyClickListener;

    public RemindNoticeAdapter(Context context, List<RemindNoticeTypeEntity> list) {
        this.context = context;
        this.list = list;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public interface OnMyClickListener {
        void onClick(View view);
    }

    public void setOnMyClickListener(OnMyClickListener onMyClickListener) {
        this.onMyClickListener = onMyClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        if(viewType == TITLE) {
//            return new TitleViewHolder(mLayoutInflater.inflate(R.layout.item_remind_notice1, parent, false));
//        } else if(viewType == ITEM) {
            return new ItemViewHolder(mLayoutInflater.inflate(R.layout.item_remind_notice2, parent, false));
//        }
//        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if(holder instanceof TitleViewHolder) {
//            ((TitleViewHolder)holder).title.setText(list.get(position).getTitle());
//        } else if( holder instanceof ItemViewHolder) {
            ((ItemViewHolder)holder).relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMyClickListener.onClick(v);
                }
            });
            ((ItemViewHolder)holder).title.setText(list.get(position).getTitle());
            ((ItemViewHolder)holder).num.setText(list.get(position).getRemindNum() + "");
//        }
    }

//    @Override
//    public int getItemViewType(int position) {
//        if(position == 0 || position == 6 || position == 10 || position == 13) {
//            return TITLE;
//        } else {
//            return ITEM;
//        }
//    }

    @Override
    public int getItemCount() {
        return list.size();
    }

//    public class TitleViewHolder extends RecyclerView.ViewHolder {
//        private TextView title;
//
//        public TitleViewHolder(View itemView) {
//            super(itemView);
//            title = (TextView) itemView.findViewById(R.id.irn1_title);
//        }
//    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView num;
        private RelativeLayout relativeLayout;

        public ItemViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.irn2_title);
            num = (TextView) itemView.findViewById(R.id.irn2_num);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.irn2_relativeLayout);
        }
    }

}
