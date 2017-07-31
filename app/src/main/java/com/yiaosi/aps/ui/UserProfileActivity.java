package com.yiaosi.aps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.hyphenate.chatuidemo.Constant;
import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.hyphenate.chatuidemo.ui.ChatActivity;
import com.yiaosi.aps.R;
import com.yiaosi.aps.widget.EditItem;

/**
 * Created by Administrator on 2017-06-13.
 */

public class UserProfileActivity extends BaseActivity {
    private EditItem name, department, position, phone, email, address;
    private FloatingActionButton fab;
    private Button btnSendMsg;

    private String member;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_user_profile);

        member = getIntent().getStringExtra(Constant.EXTRA_USER_ID);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(member);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        CollapsingToolbarLayout collapsing = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        collapsing.setTitle(member);

        name = (EditItem) findViewById(R.id.aup_name);
        department = (EditItem) findViewById(R.id.aup_department);
        position = (EditItem) findViewById(R.id.aup_position);
        phone = (EditItem) findViewById(R.id.aup_phone);
        email = (EditItem) findViewById(R.id.aup_email);
        address = (EditItem) findViewById(R.id.aup_address);

        fab = (FloatingActionButton) findViewById(R.id.aup_sendMsg);
        btnSendMsg = (Button) findViewById(R.id.aup_btnSendMsg);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, ChatActivity.class);
                // it's single chat
                intent.putExtra(Constant.EXTRA_USER_ID, member);
                startActivity(intent);
            }
        });

        btnSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, ChatActivity.class);
                // it's single chat
                intent.putExtra(Constant.EXTRA_USER_ID, member);
                startActivity(intent);
            }
        });
    }
}
