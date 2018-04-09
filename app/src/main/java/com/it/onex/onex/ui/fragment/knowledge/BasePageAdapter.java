package com.it.onex.onex.ui.fragment.knowledge;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.it.onex.onex.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Linsa on 2018/4/9:22:03.
 * des:
 */

public class BasePageAdapter extends FragmentPagerAdapter {

    private ArrayList<BaseFragment> mFragment;
    private ArrayList<String> titles;

    public BasePageAdapter(FragmentManager fm, ArrayList<BaseFragment> fragments) {
        super(fm);
        this.mFragment=fragments;
        titles=new ArrayList<>();
        titles.add("文章");
        titles.add("我的");
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
