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

import com.google.gson.Gson;
import com.hyphenate.EMError;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chatuidemo.DemoHelper;
import com.yiaosi.aps.R;
import com.hyphenate.exceptions.HyphenateException;
import com.yiaosi.aps.constant.Constant;
import com.yiaosi.aps.entity.CheckUserExistEntity;
import com.yiaosi.aps.entity.RegisterEntity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;

import static com.yiaosi.aps.R.id.username;

/**
 * register screen
 * 
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener {
	private EditText userNameEditText;
	private EditText passwordEditText;
	private EditText confirmPwdEditText;
	private EditText verifiCodeEditText;
	private Button btnCountDown;
	private int time = 60;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.em_activity_register);
		userNameEditText = (EditText) findViewById(R.id.username);
		passwordEditText = (EditText) findViewById(R.id.password);
		confirmPwdEditText = (EditText) findViewById(R.id.confirm_password);
		verifiCodeEditText = (EditText) findViewById(R.id.ed_VerifiCode);
		btnCountDown = (Button) findViewById(R.id.btn_CountDown);
		btnCountDown.setOnClickListener(this);
	}


    /**
	 * 先验证用户名是否重复，不重复的话，再进行注册
	 * @param view
	 */
	public void register(View view) {
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				String path = "http://192.168.11.22:8080/apsapp/register";
//				try {
//					URL url = new URL(path);
//					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//					connection.setConnectTimeout(5000);
//					connection.setRequestMethod("POST");
//
//					//数据准备
//					String data = "userName="+userNameEditText.getText().toString()+"&phone="+userNameEditText.getText().toString()+"&password="+confirmPwdEditText.getText().toString();
//					//至少要设置的两个请求头
//					connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
//					connection.setRequestProperty("Content-Length", data.length()+"");
//
//					//post的方式提交实际上是留的方式提交给服务器
//					connection.setDoOutput(true);
//					OutputStream outputStream = connection.getOutputStream();
//					outputStream.write(data.getBytes());
//
//					//获得结果码
//					int responseCode = connection.getResponseCode();
//					if(responseCode ==200){
//						//请求成功
//						InputStream is = connection.getInputStream();
//						ByteArrayOutputStream baos = new ByteArrayOutputStream();
//						int len = 0;
//						byte[] buffer = new byte[1024];
//						while ((len = is.read(buffer))!=-1) {
//							baos.write(buffer, 0, len);
//						}
//						is.close();
//						baos.close();
//						byte[] result = baos.toByteArray();
//						String temp = new String(result);
//						Log.e("", temp);
//					}else {
//						//请求失败
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();

//		OkHttpUtils
//				.get()
//				.url(Constant.checkUser)
//				.addParams("userName", userNameEditText.getText().toString())
//				.build()
//				.execute(new CheckUserCallback());
		registerIM();
	}

	class Register {
		String username;
		String password;

		public Register(String username, String password) {
			this.username = username;
			this.password = password;
		}
	}

	public class CheckUserCallback extends StringCallback {
		@Override
		public void onBefore(Request request, int id) {
			Log.e("as", request.toString());
		}

		@Override
		public void onAfter(int id) {
			Log.e("as", id + "");
		}

		@Override
		public void onError(Call call, Exception e, int id) {
			e.printStackTrace();
		}

		@Override
		public void onResponse(String response, int id) {
			Gson gson = new Gson();
			CheckUserExistEntity entity = gson.fromJson(response, CheckUserExistEntity.class);
			if(entity.getStatus() == 200) {
//				OkHttpUtils
//						.post()
//						.url(Constant.register)
//						.addParams("userName", userNameEditText.getText().toString())
//						.addParams("phone", userNameEditText.getText().toString())
//						.addParams("password", confirmPwdEditText.getText().toString())
//						.build()
//						.execute(new RegisterCallback());
				OkHttpUtils
						.postString()
						.url(Constant.register)
						.content(new Gson().toJson(new Register("13822544555", "123456")))
//				        .addParams("username", userNameEditText.getText().toString())
//				        .addParams("password", confirmPwdEditText.getText().toString())
						.mediaType(MediaType.parse("application/json; charset=utf-8"))
						.build()
						.execute(new RegisterCallback());
			} else if(entity.getStatus() == 401 && entity.getResult().getFailedMsg().contains(" has been used")) {
				Toast.makeText(RegisterActivity.this, "该号码已经注册", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_SHORT).show();
			}

		}

		@Override
		public void inProgress(float progress, long total, int id) {
//            mProgressBar.setProgress((int) (100 * progress));
		}
	}

	public class RegisterCallback extends StringCallback {
		@Override
		public void onBefore(Request request, int id) {
			Log.e("as", request.toString());
		}

		@Override
		public void onAfter(int id) {
			Log.e("as", id + "");
		}

		@Override
		public void onError(Call call, Exception e, int id) {
			e.printStackTrace();
		}

		@Override
		public void onResponse(String response, int id) {
			Gson gson = new Gson();
			RegisterEntity entity = gson.fromJson(response, RegisterEntity.class);
			if(entity.getStatus() == 200 && entity.getMsg().equals("success")) {
				registerIM();
			} else {
				Toast.makeText(RegisterActivity.this, "服务方忙，请稍后再试", Toast.LENGTH_SHORT).show();
			}

		}

		@Override
		public void inProgress(float progress, long total, int id) {
//            mProgressBar.setProgress((int) (100 * progress));
		}
	}

	public void registerIM() {
		final String username = userNameEditText.getText().toString().trim();
		final String pwd = passwordEditText.getText().toString().trim();
		String confirm_pwd = confirmPwdEditText.getText().toString().trim();
		if (TextUtils.isEmpty(username)) {
			Toast.makeText(this, getResources().getString(R.string.User_name_cannot_be_empty), Toast.LENGTH_SHORT).show();
			userNameEditText.requestFocus();
			return;
		} else if (TextUtils.isEmpty(pwd)) {
			Toast.makeText(this, getResources().getString(R.string.Password_cannot_be_empty), Toast.LENGTH_SHORT).show();
			passwordEditText.requestFocus();
			return;
		} else if (TextUtils.isEmpty(confirm_pwd)) {
			Toast.makeText(this, getResources().getString(R.string.Confirm_password_cannot_be_empty), Toast.LENGTH_SHORT).show();
			confirmPwdEditText.requestFocus();
			return;
		} else if (!pwd.equals(confirm_pwd)) {
			Toast.makeText(this, getResources().getString(R.string.Two_input_password), Toast.LENGTH_SHORT).show();
			return;
		}

		if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(pwd)) {
			final ProgressDialog pd = new ProgressDialog(this);
			pd.setMessage(getResources().getString(R.string.Is_the_registered));
			pd.show();

			new Thread(new Runnable() {
				public void run() {
					try {
						// call method in SDK
						EMClient.getInstance().createAccount(username, pwd);
						runOnUiThread(new Runnable() {
							public void run() {
								if (!RegisterActivity.this.isFinishing())
									pd.dismiss();
								// save current user
								DemoHelper.getInstance().setCurrentUserName(username);
								Toast.makeText(getApplicationContext(), getResources().getString(R.string.Registered_successfully), Toast.LENGTH_SHORT).show();
								finish();
							}
						});
					} catch (final HyphenateException e) {
						runOnUiThread(new Runnable() {
							public void run() {
								if (!RegisterActivity.this.isFinishing())
									pd.dismiss();
								int errorCode=e.getErrorCode();
								if(errorCode==EMError.NETWORK_ERROR){
									Toast.makeText(getApplicationContext(), getResources().getString(R.string.network_anomalies), Toast.LENGTH_SHORT).show();
								}else if(errorCode == EMError.USER_ALREADY_EXIST){
									Toast.makeText(getApplicationContext(), getResources().getString(R.string.User_already_exists), Toast.LENGTH_SHORT).show();
								}else if(errorCode == EMError.USER_AUTHENTICATION_FAILED){
									Toast.makeText(getApplicationContext(), getResources().getString(R.string.registration_failed_without_permission), Toast.LENGTH_SHORT).show();
								}else if(errorCode == EMError.USER_ILLEGAL_ARGUMENT){
								    Toast.makeText(getApplicationContext(), getResources().getString(R.string.illegal_user_name),Toast.LENGTH_SHORT).show();
								}else{
									Toast.makeText(getApplicationContext(), getResources().getString(R.string.Registration_failed), Toast.LENGTH_SHORT).show();
								}
							}
						});
					}
				}
			}).start();

		}
	}

	public void back(View view) {
		finish();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_CountDown:
				final Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								if(time > 0) {
									btnCountDown.setText("验证码(" + time-- + ")");
									btnCountDown.setEnabled(false);
								} else {
									time = 60;
									timer.cancel();
									btnCountDown.setText("验证码");
									btnCountDown.setEnabled(true);
								}
							}
						});
					}
				}, 500, 1000);
				break;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
