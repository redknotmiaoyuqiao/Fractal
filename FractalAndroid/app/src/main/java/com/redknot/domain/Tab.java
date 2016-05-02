package com.redknot.domain;

import android.support.v4.app.Fragment;

/**
 * Created by miaoyuqiao on 16/5/2.
 */
public class Tab {
    private String title;
    private Fragment fragment;

    public Tab(String title,Fragment fragment){
        this.title = title;
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
