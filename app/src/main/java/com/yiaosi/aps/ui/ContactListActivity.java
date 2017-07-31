package com.yiaosi.aps.ui;

import android.os.Bundle;

import com.hyphenate.chatuidemo.ui.BaseActivity;
import com.hyphenate.chatuidemo.ui.ContactListFragment;
import com.yiaosi.aps.R;

/**
 * Created by Administrator on 2017-06-09.
 */

public class ContactListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_contact_list);

        getSupportFragmentManager().beginTransaction().add(R.id.acl_frameLaout,
                new ContactListFragment()).commit();
    }
}
