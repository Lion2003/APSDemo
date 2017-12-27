package com.yiaosi.aps.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMCursorResult;
import com.hyphenate.chat.EMGroup;
import com.hyphenate.chatuidemo.Constant;
import com.hyphenate.chatuidemo.DemoHelper;
import com.hyphenate.chatuidemo.adapter.GroupAdapter;
import com.hyphenate.chatuidemo.db.InviteMessgeDao;
import com.hyphenate.chatuidemo.ui.AddContactActivity;
import com.hyphenate.chatuidemo.ui.ChatActivity;
import com.hyphenate.chatuidemo.ui.GroupsActivity;
import com.hyphenate.chatuidemo.ui.MainActivity;
import com.hyphenate.chatuidemo.ui.NewFriendsMsgActivity;
import com.hyphenate.chatuidemo.ui.NewGroupActivity;
import com.hyphenate.chatuidemo.ui.PublicGroupsActivity;
import com.hyphenate.chatuidemo.widget.ContactItemView;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.EMLog;
import com.yiaosi.aps.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-06-06.
 */

public class GroupListFragment extends Fragment {
    private View view;
    public static final String TAG = "GroupsActivity";
    private ListView groupListView;
    protected List<EMGroup> grouplist;
    private GroupAdapter groupAdapter;
    private InputMethodManager inputMethodManager;
    private View progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ImageView imgSearch, imgAddContact;
    private ContactItemView contactItemView;
    private InviteMessgeDao inviteMessgeDao;

    private EMGroup group;
    private List<String> adminList = Collections.synchronizedList(new ArrayList<String>());
    private List<String> memberList = Collections.synchronizedList(new ArrayList<String>());
    private List<String> muteList = Collections.synchronizedList(new ArrayList<String>());
    private List<String> blackList = Collections.synchronizedList(new ArrayList<String>());


    Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            swipeRefreshLayout.setRefreshing(false);
            switch (msg.what) {
                case 0:
                    refresh();
                    break;
                case 1:
                    Toast.makeText(getActivity(), R.string.Failed_to_get_group_chat_information, Toast.LENGTH_LONG).show();
                    break;

                default:
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.em_fragment_groups, container, false);

        imgSearch = (ImageView) view.findViewById(R.id.efg_imgSearch);
        imgAddContact = (ImageView) view.findViewById(R.id.efg_imgAddContact);

        inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        grouplist = EMClient.getInstance().groupManager().getAllGroups();
        LinearLayout ll = (LinearLayout) view.findViewById(R.id.ecbb_img_arror);
        ll.setVisibility(View.GONE);
        groupListView = (ListView) view.findViewById(R.id.list);
        addHeaderView(groupListView);
        //show group list
        groupAdapter = new GroupAdapter(getActivity(), 1, grouplist);
        groupListView.setAdapter(groupAdapter);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_layout);
        swipeRefreshLayout.setColorSchemeResources(R.color.holo_blue_bright, R.color.holo_green_light,
                R.color.holo_orange_light, R.color.holo_red_light);
        //pull down to refresh
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(){
                    @Override
                    public void run(){
                        try {
                            EMClient.getInstance().groupManager().getJoinedGroupsFromServer();
                            handler.sendEmptyMessage(0);
                        } catch (HyphenateException e) {
                            e.printStackTrace();
                            handler.sendEmptyMessage(1);
                        }
                    }
                }.start();
            }
        });

        groupListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                if (position == 0){
                    // 进入申请与通知页面
                    startActivity(new Intent(getActivity(), NewFriendsMsgActivity.class));
                } else if (position == 1) {
                    // create a new group
                    startActivityForResult(new Intent(getActivity(), NewGroupActivity.class), 0);
                } else if (position == 2) {
//                    startActivity();
                    startActivity(new Intent(getActivity(), CompanyMemberListActivity.class));
                }
//                else if (position == 2) {
//                    // join a public group
//                    startActivityForResult(new Intent(getActivity(), PublicGroupsActivity.class), 0);
//                }
                else {
                    ((MainActivity)getActivity()).showGroupMemberList(groupAdapter.getItem(position - 2).getGroupId(), grouplist.get(position - 2).getGroupName());


//                    // enter group chat
//                    Intent intent = new Intent(getActivity(), ChatActivity.class);
//                    // it is group chat
//                    intent.putExtra("chatType", Constant.CHATTYPE_GROUP);
//                    intent.putExtra("userId", groupAdapter.getItem(position - 3).getGroupId());
//                    startActivityForResult(intent, 0);
                }
            }

        });
        groupListView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (getActivity().getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
                    if (getActivity().getCurrentFocus() != null)
                        inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                                InputMethodManager.HIDE_NOT_ALWAYS);
                }
                return false;
            }
        });

        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ContactListActivity1.class));
            }
        });

        imgAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddContactActivity.class));
            }
        });

        return view;
    }

    private void addHeaderView(ListView groupListView) {
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.header_notice, null);
        contactItemView = (ContactItemView) headerView.findViewById(R.id.application_item);
        contactItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 进入申请与通知页面
                startActivity(new Intent(getActivity(), NewFriendsMsgActivity.class));
            }
        });
        groupListView.addHeaderView(headerView);

    }

    @Override
    public void onResume() {
        refresh();
        super.onResume();
    }

    public void refresh(){
        grouplist = EMClient.getInstance().groupManager().getAllGroups();
        groupAdapter = new GroupAdapter(getActivity(), 1, grouplist);
        groupListView.setAdapter(groupAdapter);
        groupAdapter.notifyDataSetChanged();

    }

    public void updateUnreadAddressLabel() {
        if(inviteMessgeDao == null){
            inviteMessgeDao = new InviteMessgeDao(getActivity());
        }
        if(inviteMessgeDao.getUnreadMessagesCount() > 0){
            contactItemView.showUnreadMsgView();
        }else{
            contactItemView.hideUnreadMsgView();
        }
    }

}
