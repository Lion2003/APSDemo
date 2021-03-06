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

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.hyphenate.easeui.ui.EaseBaseActivity;
import com.umeng.analytics.MobclickAgent;
import com.yiaosi.aps.R;
import com.yiaosi.aps.utils.StatusBarUtils;

@SuppressLint("Registered")
public class BaseActivity extends EaseBaseActivity {

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //接入了环信之后，状态栏变成白色，无法通过配置问价改为别的颜色。这里先用一下方式实现状态栏颜色改变。
        StatusBarUtils.setWindowStatusBarColor(this, R.color.status_bar_color);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // umeng
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // umeng
//        MobclickAgent.onPause(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // umeng
        MobclickAgent.onPause(this);
    }
}
