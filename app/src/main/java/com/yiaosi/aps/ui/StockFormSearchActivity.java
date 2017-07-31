package com.yiaosi.aps.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.yiaosi.aps.R;
import com.yiaosi.aps.widget.EditItem;
import com.yiaosi.aps.widget.timepickerdlg.TimePickerDialog;
import com.yiaosi.aps.widget.timepickerdlg.data.Type;
import com.yiaosi.aps.widget.timepickerdlg.listener.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 库存报表查询
 * Created by Administrator on 2017-06-07.
 */

public class StockFormSearchActivity extends BaseActivity {
    private EditItem beginDate, clientName, dakuan, materielName, colorNum;
    private Button btnSearch;

    private ListView popListView;
    private List<Map<String, String>> statusData1;
    private PopupWindow popMenu;
    private SimpleAdapter menuAdapter1;
    private LinearLayout product;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_sotck_from_search);
        initTitleBar();
        initView();
        initListener();
    }

    private void initMenuData() {
        statusData1 = new ArrayList<Map<String, String>>();
        String[] menuStr1 = new String[] { "全部", "主料仓库", "辅料仓库"};
        Map<String, String> map1;
        for (int i = 0, len = menuStr1.length; i < len; ++i) {
            map1 = new HashMap<String, String>();
            map1.put("name", menuStr1[i]);
            statusData1.add(map1);
        }
    }

    private void initPopMenu() {
        initMenuData();
        View contentView = View.inflate(this, R.layout.popwin_supplier_list,
                null);
        popMenu = new PopupWindow(contentView,
                tvStatus.getWidth() + 70, LinearLayout.LayoutParams.WRAP_CONTENT);
        popMenu.setOutsideTouchable(true);
        popMenu.setBackgroundDrawable(new BitmapDrawable());
        popMenu.setFocusable(true);
        popMenu.setAnimationStyle(R.style.popwin_anim_style);
        popMenu.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                tvStatus.setTextColor(Color.parseColor("#5a5959"));
            }
        });

        popListView = (ListView) contentView.findViewById(R.id.popwin_supplier_list_lv);
        contentView.findViewById(R.id.popwin_supplier_list_bottom)
                .setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        popMenu.dismiss();
                    }
                });
        menuAdapter1 = new SimpleAdapter(this, statusData1,
                R.layout.item_listview_popwin, new String[] { "name" },
                new int[] { R.id.listview_popwind_tv });

        popListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
                                    long arg3) {
                popMenu.dismiss();
                String name = statusData1.get(pos).get("name");
                tvStatus.setText(name);
            }
        });
    }

    private void initView() {
        beginDate = (EditItem) findViewById(R.id.asfs_beginDate);
        clientName = (EditItem) findViewById(R.id.asfs_client_name);
        dakuan = (EditItem) findViewById(R.id.asfs_dakuan);
        materielName = (EditItem) findViewById(R.id.asfs_materiel_name);
        colorNum = (EditItem) findViewById(R.id.asfs_color_num);
        btnSearch = (Button) findViewById(R.id.btn_search);

        product = (LinearLayout) findViewById(R.id.supplier_list_activity);
        tvStatus = (TextView) findViewById(R.id.supplier_list_activity_tv);
    }

    private void initListener() {
        titleBar.setLeftLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        beginDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData(beginDate);
            }
        });

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopMenu();

                tvStatus.setTextColor(Color.parseColor("#39ac69"));
                popListView.setAdapter(menuAdapter1);
                popMenu.showAsDropDown(product, 0, 2);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(StockFormSearchActivity.this, StockFormListActivity.class);
                startActivity(it);
            }
        });

    }

    /**
     * 设置时间
     * @param tv
     */
    private void setData(final EditItem tv) {
        TimePickerDialog mDialogYearMonthDay = new TimePickerDialog.Builder()
                .setType(Type.YEAR_MONTH_DAY)
                .setCallBack(new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
                        Date d = new Date(millseconds);
                        String date = sf.format(d);
                        tv.setValue(date);
                    }
                })
                .build();
        mDialogYearMonthDay.show(getSupportFragmentManager(), "year_month_day");
    }

}
