package com.redknot.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.redknot.domain.Tab;

import java.util.List;

/**
 * Created by miaoyuqiao on 16/5/2.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {

    private List<Tab> tabList;

    public FragmentAdapter(FragmentManager fm,List<Tab> tabList) {
        super(fm);
        this.tabList = tabList;
    }

    @Override
    public Fragment getItem(int position) {
        return this.tabList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return this.tabList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.tabList.get(position).getTitle();
    }
}
