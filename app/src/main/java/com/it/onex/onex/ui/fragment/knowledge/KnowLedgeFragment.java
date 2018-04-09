package com.it.onex.onex.ui.fragment.knowledge;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.ui.fragment.home.HomeFragment;
import com.it.onex.onex.ui.fragment.me.MeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by OnexZgj on 2018/4/2:22:08.
 * des:
 */

public class KnowLedgeFragment extends BaseFragment {


    @BindView(R.id.tl_fk)
    TabLayout tlFk;
    @BindView(R.id.vp_fk)
    ViewPager vpFk;
    Unbinder unbinder;

    private ArrayList<BaseFragment> fragments=new ArrayList<>();

    public static KnowLedgeFragment getInstance() {
        return new KnowLedgeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_knowledge;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView(View view) {
        fragments.add(HomeFragment.getInstance());
        fragments.add(MeFragment.getInstance());

        vpFk.setAdapter(new BasePageAdapter(getFragmentManager(),fragments));

        tlFk.setupWithViewPager(vpFk);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
