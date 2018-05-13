package com.it.onex.onex.ui.fragment.gank.custom;

import android.view.View;

import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;

/**
 * Created by OnexZgj on 2018/5/3:17:15.
 * des:干货分类Fragment
 */

public class GankCustomFragment extends BaseFragment{
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initInjector() {
//        mFragmentComponent.inject(this);
    }

    @Override
    protected void initView(View view) {

    }

    public static BaseFragment getInstance() {
        return new GankCustomFragment();
    }
}
