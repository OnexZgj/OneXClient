package com.it.onex.onex.ui.fragment.navigation;

import android.view.View;

import com.it.onex.onex.base.BaseFragment;

/**
 * Created by Linsa on 2018/4/16:22:21.
 * des导航体系结构
 */

public class NavigationFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView(View view) {

    }

    public static NavigationFragment getInstance() {
        return new NavigationFragment();
    }
}
