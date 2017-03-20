package com.suozhang.hotel.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by LIJUWEN on 2017/3/20.
 * ViewPager适配器
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<String> mTitles;
    private List<Fragment> mFragments;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mTitles = new ArrayList<>();
        mFragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }


    public void setItem(List<String> mTitles, List<Fragment> mFragments) {
        this.mTitles = mTitles;
        this.mFragments = mFragments;
        notifyDataSetChanged();
    }


    public void setItem(String[] mTitles, List<Fragment> mFragments) {
        this.mTitles = Arrays.asList(mTitles);
        this.mFragments = mFragments;
        notifyDataSetChanged();
    }

    public void addItem(String title, Fragment fragment) {
        this.mTitles.add(title);
        this.mFragments.add(fragment);
        notifyDataSetChanged();
    }

    public void delItem(int position) {
        this.mFragments.remove(position);
        this.mTitles.remove(position);
        notifyDataSetChanged();
    }

    public int delItem(String title) {
        int index = mTitles.indexOf(title);
        if (index != -1) {
            delItem(index);
        }

        return index;
    }


    /**
     * 交换集合中元素位置
     */

    public void changeItem(int startPos, int endPos) {
        Collections.swap(mTitles, startPos, endPos);
        Collections.swap(mFragments, startPos, endPos);
        notifyDataSetChanged();
    }

    /**
     * 改变title
     */

    public void changeItemTitle(int position, String title) {
        mTitles.set(position, title);
        notifyDataSetChanged();
    }
}
