package com.it.onex.onex.ui.fragment.gank.day;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by OnexZgj on 2018/5/3:17:15.
 * des:干货每日推荐Fragment
 */

public class GankDayFragment extends BaseFragment {

    @BindView(R.id.rv_fgid_day)
    RecyclerView rvFgidDay;
    @BindView(R.id.srl_fgid_day)
    SwipeRefreshLayout srlFgidDay;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank_io_day;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView(View view) {

    }

    public static BaseFragment getInstance() {
        return new GankDayFragment();
    }

}
