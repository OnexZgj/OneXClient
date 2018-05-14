package com.it.onex.onex.ui.fragment.gank.custom;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by OnexZgj on 2018/5/3:17:15.
 * des:干货分类Fragment
 */

public class GankCustomFragment extends BaseFragment {
    @BindView(R.id.rv_fc_custom)
    RecyclerView rvFcCustom;
    @BindView(R.id.srl_fc_custome)
    SwipeRefreshLayout srlFcCustome;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_custome;
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
