package com.yiaosi.aps.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017-07-20.
 */

public class RemindNoticeViewPagerAdapter extends FragmentStatePagerAdapter {
    private String[] titles;
    private List<Fragment> fragments;

    public RemindNoticeViewPagerAdapter(FragmentManager fm, String[] titles, List<Fragment> fragments) {
        super(fm);
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
