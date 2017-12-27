package com.yiaosi.aps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yiaosi.aps.R;
import com.yiaosi.aps.entity.CompanyMemberEntity.ResultBean.PageInfoBean.ListBean;

import java.util.List;

/**
 * Created by Administrator on 2017-12-08.
 */

public class CompanyMemberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private Context context;
    private List<ListBean> list;
    private OnMyClickListener onMyClickListener;

    public CompanyMemberAdapter(Context context, List<ListBean> list) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.list = list;
    }

    public interface OnMyClickListener {
        void onClick(String id);
    }

    public void setOnMyClickListener(OnMyClickListener onMyClickListener) {
        this.onMyClickListener = onMyClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OverAuditingViewHolder(mLayoutInflater.inflate(R.layout.item_company_member, parent, false));
    }

    /**
     * onBindViewHolder专门用来绑定ViewHolder里的控件he数据源中positin位置的数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((OverAuditingViewHolder)holder).username.setText("姓名：" + list.get(position).getNickname());
        ((OverAuditingViewHolder)holder).phone.setText("电话：" + list.get(position).getPhone());
        ((OverAuditingViewHolder)holder).icm_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMyClickListener.onClick(list.get(position).getPhone());
            }
        });
    }

    @Override
    public int getItemCount() {
        return (list.size() == 0) ? 0 : list.size();
    }

    public class OverAuditingViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout icm_layout;
        TextView username;
        TextView phone;

        public OverAuditingViewHolder(View itemView) {
            super(itemView);
            icm_layout = (RelativeLayout) itemView.findViewById(R.id.icm_layout);
            username = (TextView) itemView.findViewById(R.id.icm_username);
            phone = (TextView) itemView.findViewById(R.id.icm_phone);
        }
    }

}
