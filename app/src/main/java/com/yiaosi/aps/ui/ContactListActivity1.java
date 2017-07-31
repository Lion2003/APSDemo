package com.yiaosi.aps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;

import com.hyphenate.EMConnectionListener;
import com.hyphenate.EMError;
import com.hyphenate.EMValueCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.hyphenate.chatuidemo.ui.ChatActivity;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.ui.EaseContactListFragment;
import com.hyphenate.easeui.utils.EaseCommonUtils;
import com.hyphenate.easeui.utils.EaseUserUtils;
import com.hyphenate.easeui.widget.EaseContactList;
import com.hyphenate.exceptions.HyphenateException;
import com.yiaosi.aps.R;
import com.yiaosi.aps.utils.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-06-15.
 */

public class ContactListActivity1 extends BaseActivity {
    private static final String TAG = "EaseContactListFragment";
    protected List<EaseUser> contactList;
    protected ListView listView;
    protected boolean hidden;
    protected ImageButton clearSearch;
    protected EditText query;
    protected Handler handler = new Handler();
    protected EaseUser toBeProcessUser;
    protected String toBeProcessUsername;
    protected EaseContactList contactListLayout;
    protected boolean isConflict;
    protected FrameLayout contentContainer;

    private Map<String, EaseUser> contactsMap;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.ease_fragment_contact_list);

        contentContainer = (FrameLayout) findViewById(com.hyphenate.easeui.R.id.content_container);
        contactListLayout = (EaseContactList) findViewById(com.hyphenate.easeui.R.id.contact_list);
        listView = contactListLayout.getListView();

        //search
        query = (EditText) findViewById(com.hyphenate.easeui.R.id.query);
        clearSearch = (ImageButton) findViewById(com.hyphenate.easeui.R.id.search_clear);

        asyncFetchContactsFromServer(null);
    }


    @Override
    public void onDestroy() {

        EMClient.getInstance().removeConnectionListener(connectionListener);

        super.onDestroy();
    }


    /**
     * get contact list and sort, will filter out users in blacklist
     */
    protected void getContactList() {
        contactList.clear();
        if(contactsMap == null){
            return;
        }
        synchronized (this.contactsMap) {
            Iterator<Map.Entry<String, EaseUser>> iterator = contactsMap.entrySet().iterator();
            List<String> blackList = EMClient.getInstance().contactManager().getBlackListUsernames();
            while (iterator.hasNext()) {
                Map.Entry<String, EaseUser> entry = iterator.next();
                // to make it compatible with data in previous version, you can remove this check if this is new app
                if (!entry.getKey().equals("item_new_friends")
                        && !entry.getKey().equals("item_groups")
                        && !entry.getKey().equals("item_chatroom")
                        && !entry.getKey().equals("item_robots")){
                    if(!blackList.contains(entry.getKey())){
                        //filter out users in blacklist
                        EaseUser user = entry.getValue();
                        EaseCommonUtils.setUserInitialLetter(user);
                        contactList.add(user);
                    }
                }
            }
        }

        // sorting
        Collections.sort(contactList, new Comparator<EaseUser>() {

            @Override
            public int compare(EaseUser lhs, EaseUser rhs) {
                if(lhs.getInitialLetter().equals(rhs.getInitialLetter())){
                    return lhs.getNick().compareTo(rhs.getNick());
                }else{
                    if("#".equals(lhs.getInitialLetter())){
                        return 1;
                    }else if("#".equals(rhs.getInitialLetter())){
                        return -1;
                    }
                    return lhs.getInitialLetter().compareTo(rhs.getInitialLetter());
                }

            }
        });

    }



    protected EMConnectionListener connectionListener = new EMConnectionListener() {

        @Override
        public void onDisconnected(int error) {
            if (error == EMError.USER_REMOVED || error == EMError.USER_LOGIN_ANOTHER_DEVICE || error == EMError.SERVER_SERVICE_RESTRICTED) {
                isConflict = true;
            } else {
                runOnUiThread(new Runnable() {
                    public void run() {
                        onConnectionDisconnected();
                    }

                });
            }
        }

        @Override
        public void onConnected() {
            runOnUiThread(new Runnable() {
                public void run() {
                    onConnectionConnected();
                }

            });
        }
    };
    private EaseContactListFragment.EaseContactListItemClickListener listItemClickListener;


    protected void onConnectionDisconnected() {

    }

    protected void onConnectionConnected() {

    }

    /**
     * set contacts map, key is the hyphenate id
     * @param contactsMap
     */
    public void setContactsMap(Map<String, EaseUser> contactsMap){
        this.contactsMap = contactsMap;
    }

    public interface EaseContactListItemClickListener {
        /**
         * on click event for item in contact list
         * @param user --the user of item
         */
        void onListItemClicked(EaseUser user);
    }

    /**
     * set contact list item click listener
     * @param listItemClickListener
     */
    public void setContactListItemClickListener(EaseContactListFragment.EaseContactListItemClickListener listItemClickListener){
        this.listItemClickListener = listItemClickListener;
    }

    private List<EaseUser> list;
    public void asyncFetchContactsFromServer(final EMValueCallBack<List<String>> callback){
        new Thread(){
            @Override
            public void run(){
                List<String> usernames = null;
                try {
                    usernames = EMClient.getInstance().contactManager().getAllContactsFromServer();
                    // in case that logout already before server returns, we should return immediately

                    Map<String, EaseUser> userlist1 = new HashMap<String, EaseUser>();
                    for (String username : usernames) {
                        EaseUser user = new EaseUser(username);
                        if(!StringUtil.isEmpty(EaseUserUtils.getUserInfo(username).getNick())){
                            user.setNick(EaseUserUtils.getUserInfo(username).getNick());
                        }
//                        EaseCommonUtils.setUserInitialLetter(user);
                        userlist1.put(username, user);
                    }

                    List<EaseUser> userlist = new ArrayList<EaseUser>();
                    for (String username : usernames) {
                        EaseUser user = new EaseUser(username);
                        if(!StringUtil.isEmpty(EaseUserUtils.getUserInfo(username).getNick())){
                            user.setNick(EaseUserUtils.getUserInfo(username).getNick());
                        }
//                        EaseCommonUtils.setUserInitialLetter(user);
                        userlist.add(user);
                    }
                    list = userlist;


                    EMClient.getInstance().addConnectionListener(connectionListener);
                    contactList = new ArrayList<EaseUser>();
                    contactList.addAll(list);
                    setContactsMap(userlist1);
                    getContactList();
                    //init list
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            contactListLayout.init(contactList);
                        }
                    });

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            EaseUser user = (EaseUser)listView.getItemAtPosition(position);
                            if (user != null) {
                                String username = user.getUsername();
                                // demo中直接进入聊天页面，实际一般是进入用户详情页
                                startActivity(new Intent(ContactListActivity1.this, ChatActivity.class).putExtra("userId", username));
                            }
                        }
                    });

                    query.addTextChangedListener(new TextWatcher() {
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            contactListLayout.filter(s);
                            if (s.length() > 0) {
                                clearSearch.setVisibility(View.VISIBLE);
                            } else {
                                clearSearch.setVisibility(View.INVISIBLE);

                            }
                        }

                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        public void afterTextChanged(Editable s) {
                        }
                    });
                    clearSearch.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            query.getText().clear();
                            hideSoftKeyboard();
                        }
                    });

                    listView.setOnTouchListener(new View.OnTouchListener() {

                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            hideSoftKeyboard();
                            return false;
                        }
                    });
                } catch (HyphenateException e) {

                }

            }
        }.start();
    }
}
