package com.it.onex.onex.ui.fragment.gank;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.ui.fragment.me.MeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by OnexZgj on 2018/4/2:22:08.
 * des:
 */

public class GankFragment extends BaseFragment {

    @BindView(R.id.tl_fg_tablayout)
    TabLayout tlFgTablayout;
    @BindView(R.id.vp_fg_con)
    ViewPager vpFgCon;

    private List<BaseFragment> mFragments=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView(View view) {
        initFragment();

        vpFgCon.setAdapter(new GankIoFragmentAdapter(getChildFragmentManager(),mFragments));

    }

    private void initFragment() {
        mFragments.add(MeFragment.getInstance());
        mFragments.add(MeFragment.getInstance());
        mFragments.add(MeFragment.getInstance());
    }



    public static GankFragment getInstance() {
        return new GankFragment();
    }

}
