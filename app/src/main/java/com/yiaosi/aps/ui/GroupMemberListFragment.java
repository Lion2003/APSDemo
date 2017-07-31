package com.yiaosi.aps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMCursorResult;
import com.hyphenate.chat.EMGroup;
import com.hyphenate.chatuidemo.Constant;
import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.hyphenate.chatuidemo.ui.ChatActivity;
import com.hyphenate.chatuidemo.ui.GroupsActivity;
import com.hyphenate.chatuidemo.ui.MainActivity;
import com.hyphenate.easeui.ui.EaseBaseFragment;
import com.hyphenate.util.EMLog;
import com.yiaosi.aps.R;
import com.yiaosi.aps.adapter.GroupMemberAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017-06-06.
 */

public class GroupMemberListFragment extends EaseBaseFragment {
//    private boolean isSelectGroupMember = false;
    public static final String TAG = "GroupsActivity";
    private View view;
    private ListView lv;
    private Button btnGroupChat;
    private String groupId; //群ID
    private String groupName; //群名

    private EMGroup group;
    private List<String> adminList = Collections.synchronizedList(new ArrayList<String>());
    private List<String> memberList = Collections.synchronizedList(new ArrayList<String>());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        groupId = bundle.getString("groupId");
        groupName = bundle.getString("groupName");

        view = inflater.inflate(R.layout.em_fragment_groupmemberlist, container, false);
        return view;
    }

    @Override
    protected void initView() {
        lv = (ListView) view.findViewById(R.id.emfg_listview);
        btnGroupChat = (Button) view.findViewById(R.id.btn_gotoGroupChat);
        btnGroupChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // enter group chat
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                // it is group chat
                intent.putExtra("chatType", Constant.CHATTYPE_GROUP);
                intent.putExtra("userId", groupId);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void setUpView() {
        titleBar.setTitle(groupName);
//        isSelectGroupMember = true;
        getGroupMemberList(groupId);

        titleBar.setLeftImageResource(R.drawable.ease_mm_title_back);
        //点击返回按钮
        titleBar.setLeftLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                isSelectGroupMember = false;
                ((MainActivity)getActivity()).hideGroupMemberList();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getActivity(), ChatActivity.class);
//                // it's single chat
//                intent.putExtra(Constant.EXTRA_USER_ID, memberList.get(position));
//                startActivity(intent);

                Intent intent = new Intent(getActivity(), UserProfileActivity.class);
                intent.putExtra(Constant.EXTRA_USER_ID, memberList.get(position));
                startActivity(intent);
            }
        });

    }

    private void getGroupMemberList(final String groupId) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    group = EMClient.getInstance().groupManager().getGroupFromServer(groupId);

                    adminList.clear();
                    adminList.addAll(group.getAdminList());
                    memberList.clear();
                    EMCursorResult<String> result = null;
                    do {
                        // page size set to 20 is convenient for testing, should be applied to big value
                        result = EMClient.getInstance().groupManager().fetchGroupMembers(groupId,
                                result != null ? result.getCursor() : "", 20);
                        EMLog.d(TAG, "fetchGroupMembers result.size:" + result.getData().size());
                        memberList.addAll(result.getData());
                    } while (result.getData().size() == 20);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            lv.setAdapter(new GroupMemberAdapter(getActivity(), memberList));
//                            isSelectGroupMember = true;

                            titleBar.setTitle(groupName + "(" + memberList.size() + "人)");
                        }
                    });
                } catch (Exception e) {
                    Log.e("groupMemberException", e.toString());
                    //e.printStackTrace();  // User may have no permission for fetch mute, fetch black list operation
                } finally {

                }
            }
        }).start();
    }

//    public boolean isSelectGroupMember() {
//        return isSelectGroupMember;
//    }
//
//    public void setIsSelectGroupMember(boolean select) {
//        isSelectGroupMember = select;
//    }

}
