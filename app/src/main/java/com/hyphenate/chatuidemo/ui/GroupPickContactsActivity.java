/**
 * Copyright (C) 2016 Hyphenate Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hyphenate.chatuidemo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.hyphenate.EMValueCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMGroup;
import com.hyphenate.chatuidemo.Constant;
import com.hyphenate.chatuidemo.DemoHelper;
import com.hyphenate.easeui.utils.EaseUserUtils;
import com.hyphenate.easeui.widget.EaseImageView;
import com.hyphenate.exceptions.HyphenateException;
import com.yiaosi.aps.R;
import com.hyphenate.easeui.adapter.EaseContactAdapter;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.widget.EaseSidebar;
import com.yiaosi.aps.ui.ContactListActivity1;
import com.yiaosi.aps.utils.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPickContactsActivity extends BaseActivity {
	/** if this is a new group */
	protected boolean isCreatingNewGroup;
	private PickContactAdapter contactAdapter;
	/** members already in the group */
	private List<String> existMembers;

	private LinearLayout linearLayout;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.em_activity_group_pick_contacts);
		linearLayout = (LinearLayout) findViewById(R.id.eagpc_linearLayout);
		btn = (Button) findViewById(R.id.eagpc_btn);

		String groupId = getIntent().getStringExtra("groupId");
		if (groupId == null) {// create new group
			isCreatingNewGroup = true;
		} else {
			// get members of the group
			EMGroup group = EMClient.getInstance().groupManager().getGroup(groupId);
			existMembers = group.getMembers();
			existMembers.add(group.getOwner());
			existMembers.addAll(group.getAdminList());
		}
		if(existMembers == null)
			existMembers = new ArrayList<String>();
		// get contact list
		List<EaseUser> alluserList = new ArrayList<EaseUser>();

//		for (EaseUser user : DemoHelper.getInstance().getContactList().values()) {
//			if (!user.getUsername().equals(Constant.NEW_FRIENDS_USERNAME) & !user.getUsername().equals(Constant.GROUP_USERNAME) & !user.getUsername().equals(Constant.CHAT_ROOM) & !user.getUsername().equals(Constant.CHAT_ROBOT))
//				alluserList.add(user);
//		}

		syncasyncFetchContactsFromServer(alluserList);
	}

	/**
	 * save selected members
	 * 
	 * @param v
	 */
	public void save(View v) {
		List<String> var = getToBeAddMembers();
		setResult(RESULT_OK, new Intent().putExtra("newmembers", var.toArray(new String[var.size()])));
		finish();
	}

	/**
	 * get selected members
	 * 
	 * @return
	 */
	private List<String> getToBeAddMembers() {
		List<String> members = new ArrayList<String>();
		int length = contactAdapter.isCheckedArray.length;
		for (int i = 0; i < length; i++) {
			String username = contactAdapter.getItem(i).getUsername();
			if (contactAdapter.isCheckedArray[i] && !existMembers.contains(username)) {
				members.add(username);
			}
		}

		return members;
	}

	/**
	 * adapter
	 */
	private class PickContactAdapter extends EaseContactAdapter {

		private boolean[] isCheckedArray;

		public PickContactAdapter(Context context, int resource, List<EaseUser> users) {
			super(context, resource, users);
			isCheckedArray = new boolean[users.size()];
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			View view = super.getView(position, convertView, parent);

			final String username = getItem(position).getUsername();

			final CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);
			ImageView avatarView = (ImageView) view.findViewById(R.id.avatar);
			TextView nameView = (TextView) view.findViewById(R.id.name);
			
			if (checkBox != null) {
			    if(existMembers != null && existMembers.contains(username)){
                    checkBox.setButtonDrawable(R.drawable.em_checkbox_bg_gray_selector1);
                }else{
                    checkBox.setButtonDrawable(R.drawable.em_checkbox_bg_color_selector);
                }

				checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						// check the exist members
						if (existMembers.contains(username)) {
								isChecked = true;
								checkBox.setChecked(true);
						}
						isCheckedArray[position] = isChecked;
						getToAddMembers();
					}
				});
				// keep exist members checked
				if (existMembers.contains(username)) {
						checkBox.setChecked(true);
						isCheckedArray[position] = true;
				} else {
					checkBox.setChecked(isCheckedArray[position]);
				}
			}

			return view;
		}
	}



	/**
	 * 自己新建的方法，用于新需求展示UI底部所选的联系人头像。======================================================================================
	 *
	 * @return
	 */
	private List<String> getToAddMembers() {
		List<String> members = new ArrayList<String>();
		int length = contactAdapter.isCheckedArray.length;
		for (int i = 0; i < length; i++) {
			String username = contactAdapter.getItem(i).getUsername();
			if (contactAdapter.isCheckedArray[i] && !existMembers.contains(username)) {
				members.add(username);
			}
		}
		linearLayout.removeAllViews();
		for(int i = 0; i < members.size(); i++) {
			View view = LayoutInflater.from(this).inflate(R.layout.item_img, null);
			EaseImageView imgLogo = (EaseImageView) view.findViewById(R.id.ii_avatar);
			linearLayout.addView(view);
		}
		btn.setText("确定(" + members.size() + "人)");
		return members;
	}



	public void back(View view){
		finish();
	}

	private List<EaseUser> userlist;
	private void syncasyncFetchContactsFromServer(final List<EaseUser> alluserList){
		new Thread(){
			@Override
			public void run(){
				List<String> usernames = null;
				try {
					usernames = EMClient.getInstance().contactManager().getAllContactsFromServer();
					// in case that logout already before server returns, we should return immediately

					userlist = new ArrayList<EaseUser>();
					for (String username : usernames) {
						EaseUser user = new EaseUser(username);
						if(!StringUtil.isEmpty(EaseUserUtils.getUserInfo(username).getNick())){
							user.setNick(EaseUserUtils.getUserInfo(username).getNick());
						}
						userlist.add(user);
					}

					for (EaseUser user : userlist) {
						if (!user.getUsername().equals(Constant.NEW_FRIENDS_USERNAME) & !user.getUsername().equals(Constant.GROUP_USERNAME) & !user.getUsername().equals(Constant.CHAT_ROOM) & !user.getUsername().equals(Constant.CHAT_ROBOT))
							alluserList.add(user);
					}

//					alluserList.clear();
//					alluserList.addAll(userlist);

					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							// sort the list
							Collections.sort(alluserList, new Comparator<EaseUser>() {

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

							ListView listView = (ListView) findViewById(R.id.list);
							contactAdapter = new PickContactAdapter(GroupPickContactsActivity.this, R.layout.em_row_contact_with_checkbox, alluserList);
							listView.setAdapter(contactAdapter);
							((EaseSidebar) findViewById(R.id.sidebar)).setListView(listView);
							listView.setOnItemClickListener(new OnItemClickListener() {

								@Override
								public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
									CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);
									checkBox.toggle();

								}
							});
						}
					});

				} catch (HyphenateException e) {

				}

			}
		}.start();
	}
	
}
