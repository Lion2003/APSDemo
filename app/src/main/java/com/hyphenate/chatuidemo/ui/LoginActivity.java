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
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chatuidemo.DemoApplication;
import com.hyphenate.chatuidemo.DemoHelper;
import com.hyphenate.chatuidemo.utils.SharedPreferencesUtil;
import com.hyphenate.exceptions.HyphenateException;
import com.yiaosi.aps.R;
import com.hyphenate.chatuidemo.db.DemoDBManager;
import com.hyphenate.easeui.utils.EaseCommonUtils;
import com.yiaosi.aps.utils.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Login screen
 *
 */
public class LoginActivity extends BaseActivity {
	private static final String TAG = "LoginActivity";
	public static final int REQUEST_CODE_SETNICK = 1;
	private EditText usernameEditText;
	private EditText passwordEditText;
	private Button btnLogin;
	private ImageView imgSeePwd;
	private boolean isCiphertext = true; //当前是否密文

	private boolean progressShow;
	private boolean autoLogin = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// enter the main activity if already logged in
		if (DemoHelper.getInstance().isLoggedIn()) {
			autoLogin = true;
			startActivity(new Intent(LoginActivity.this, MainActivity.class));

			return;
		}
		setContentView(R.layout.em_activity_login);

		usernameEditText = (EditText) findViewById(R.id.username);
		passwordEditText = (EditText) findViewById(R.id.password);
		btnLogin = (Button) findViewById(R.id.eal_btnLogin);
		imgSeePwd = (ImageView) findViewById(R.id.iv_seePwd);

		checkButLoginUse();

		imgSeePwd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isCiphertext) { //如果当前是密文，那么就转为明文
					imgSeePwd.setImageResource(R.drawable.icon_eye_open);
					passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance()); //明文
					isCiphertext = false;
				} else {
					imgSeePwd.setImageResource(R.drawable.icon_eye_cover);
					passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance()); //密文
					isCiphertext = true;
				}
			}
		});

		// if user changed, clear the password
		usernameEditText.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				passwordEditText.setText(null);
				checkButLoginUse();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		passwordEditText.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				checkButLoginUse();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE || ((event.getKeyCode() == KeyEvent.KEYCODE_ENTER) && (event.getAction() == KeyEvent.ACTION_DOWN ))) {
					login(null);
					return true;
				}
				else{
					return false;
				}
			}
		});

		if (DemoHelper.getInstance().getCurrentUsernName() != null) {
			usernameEditText.setText(DemoHelper.getInstance().getCurrentUsernName());
		}
	}

	private void checkButLoginUse() {
		if(StringUtil.isEmpty(usernameEditText.getText().toString()) || StringUtil.isEmpty(passwordEditText.getText().toString())){
			btnLogin.setEnabled(false);
			btnLogin.setBackgroundResource(R.drawable.shape_solid_cccccc_corners_3dp);
		} else {
			btnLogin.setEnabled(true);
			btnLogin.setBackgroundResource(R.drawable.em_button_login_bg);
		}
	}

	/**
	 * login
	 * 
	 * @param view
	 */
	public void login(View view) {
		if (!EaseCommonUtils.isNetWorkConnected(this)) {
			Toast.makeText(this, R.string.network_isnot_available, Toast.LENGTH_SHORT).show();
			return;
		}
		final String currentUsername = usernameEditText.getText().toString().trim();
		String currentPassword = passwordEditText.getText().toString().trim();

		if (TextUtils.isEmpty(currentUsername)) {
			Toast.makeText(this, R.string.User_name_cannot_be_empty, Toast.LENGTH_SHORT).show();
			return;
		}
		if (TextUtils.isEmpty(currentPassword)) {
			Toast.makeText(this, R.string.Password_cannot_be_empty, Toast.LENGTH_SHORT).show();
			return;
		}

		progressShow = true;
		final ProgressDialog pd = new ProgressDialog(LoginActivity.this);
		pd.setCanceledOnTouchOutside(false);
		pd.setOnCancelListener(new OnCancelListener() {

			@Override
			public void onCancel(DialogInterface dialog) {
				Log.d(TAG, "EMClient.getInstance().onCancel");
				progressShow = false;
			}
		});
		pd.setMessage(getString(R.string.Is_landing));
		pd.show();

		// After logout，the DemoDB may still be accessed due to async callback, so the DemoDB will be re-opened again.
		// close it before login to make sure DemoDB not overlap
        DemoDBManager.getInstance().closeDB();

        // reset current user name before login
        DemoHelper.getInstance().setCurrentUserName(currentUsername);
        
		final long start = System.currentTimeMillis();
		// call login method
		Log.d(TAG, "EMClient.getInstance().login");
		EMClient.getInstance().login(currentUsername, currentPassword, new EMCallBack() {

			@Override
			public void onSuccess() {
				Log.d(TAG, "login: onSuccess");
				String[] images = {"http://images.csdn.net/20170614/VCG2182f1c4a6b.jpg", "http://img5.duitang.com/uploads/item/201508/30/20150830132007_TjANX.thumb.224_0.jpeg",
						"http://images.csdn.net/20170421/1101.jpg","http://avatar.csdn.net/B/4/B/1_happydeer.jpg",
						"http://avatar.csdn.net/F/D/6/1_u013970991.jpg","http://avatar.csdn.net/6/B/C/1_briblue.jpg",
						"http://avatar.csdn.net/B/A/B/1_dog250.jpg","http://avatar.csdn.net/5/4/5/1_u013709270.jpg",
						"http://images.csdn.net/20170613/1_meitu_1.jpg","http://images.csdn.net/20170613/VCG41453507891.jpg",};
				String[] names = {"张一", "张二","张三","张四","张五","张六","张七","张八","张九","张十"};
				List<Map<String, String>> lists = new ArrayList<Map<String, String>>();
                for(int i = 0; i < 10; i++) {
					Map<String, String> map = new HashMap<String, String>();
					map.put("name", names[i]);
					map.put("images", images[i]);
					lists.add(map);
				}

				int kk = new Random().nextInt(10);
				SharedPreferencesUtil.getInstance().setUserHeadImg(lists.get(kk).get("images"));
				SharedPreferencesUtil.getInstance().setUserName(lists.get(kk).get("name"));
				DemoHelper.getInstance().getUserProfileManager().updateCurrentUserNickName(lists.get(kk).get("name"));
				DemoHelper.getInstance().getUserProfileManager().setCurrentUserAvatar(lists.get(kk).get("images"));
				DemoHelper.getInstance().setCurrentUserName(currentUsername); // 环信Id

				// ** manually load all local groups and conversation
				try {
					EMClient.getInstance().groupManager().getJoinedGroupsFromServer();
				} catch (HyphenateException e) {
					e.printStackTrace();
				}
			    EMClient.getInstance().groupManager().loadAllGroups();
			    EMClient.getInstance().chatManager().loadAllConversations();

			    // update current user's display name for APNs
				boolean updatenick = EMClient.getInstance().pushManager().updatePushNickname(
						DemoApplication.currentUserNick.trim());
				if (!updatenick) {
					Log.e("LoginActivity", "update current user nick fail");
				}

				if (!LoginActivity.this.isFinishing() && pd.isShowing()) {
				    pd.dismiss();
				}
				// get user's info (this should be get from App's server or 3rd party service)
				DemoHelper.getInstance().getUserProfileManager().asyncGetCurrentUserInfo();

				Intent intent = new Intent(LoginActivity.this,
						MainActivity.class);
				startActivity(intent);

				finish();
			}

			@Override
			public void onProgress(int progress, String status) {
				Log.d(TAG, "login: onProgress");
			}

			@Override
			public void onError(final int code, final String message) {
				Log.d(TAG, "login: onError: " + code);
				if (!progressShow) {
					return;
				}
				runOnUiThread(new Runnable() {
					public void run() {
						pd.dismiss();
						Toast.makeText(getApplicationContext(), getString(R.string.Login_failed) + message,
								Toast.LENGTH_SHORT).show();
					}
				});
			}
		});
	}

	
	/**
	 * register
	 * 
	 * @param view
	 */
	public void register(View view) {
		startActivityForResult(new Intent(this, RegisterActivity.class), 0);
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (autoLogin) {
			return;
		}
	}
}
