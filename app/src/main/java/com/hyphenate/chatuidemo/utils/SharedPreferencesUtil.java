package com.hyphenate.chatuidemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017-06-14.
 */

public class SharedPreferencesUtil {

    public static final String PREFERENCE_NAME = "saveUserInfo";
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferencesUtil mSharedPreferencesUtil;
    private static SharedPreferences.Editor editor;

    private String USER_HEAD_IMG = "user_head_img";
    private String USER_NAME = "user_name";

    private SharedPreferencesUtil(Context cxt) {
        mSharedPreferences = cxt.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
    }

    public static synchronized void init(Context cxt){
        if(mSharedPreferencesUtil == null){
            mSharedPreferencesUtil = new SharedPreferencesUtil(cxt);
        }
    }

    /**
     * get instance of PreferenceManager
     *
     * @param
     * @return
     */
    public synchronized static SharedPreferencesUtil getInstance() {
        if (mSharedPreferencesUtil == null) {
            throw new RuntimeException("please init first!");
        }
        return mSharedPreferencesUtil;
    }

    public void setUserHeadImg(String img) {
        editor.putString(USER_HEAD_IMG, img);
        editor.commit();
    }

    public void setUserName(String userName) {
        editor.putString(USER_NAME, userName);
        editor.commit();
    }

    public String getUserHeadImg() {
        return mSharedPreferences.getString(USER_HEAD_IMG, "");
    }

    public String getUserName() {
        return mSharedPreferences.getString(USER_NAME, "");
    }




















}
