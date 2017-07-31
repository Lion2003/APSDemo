package com.yiaosi.aps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yiaosi.aps.R;

import java.util.List;

/**
 *
 * Created by Administrator on 2017-06-06.
 */

public class GroupMemberAdapter extends BaseAdapter {
    private Context context;
    private List<String>  names;
    private LayoutInflater inflater;

    public GroupMemberAdapter(Context context, List<String> names) {
        this.context = context;
        this.names = names;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if(names == null) {
            return 0;
        } else {
            return names.size();
        }
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_group_member, null);
            viewHolder.name = (TextView) convertView.findViewById(R.id.igm_name);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(names.get(position));
        return convertView;
    }

    public class ViewHolder {
        private TextView name;
    }
}
