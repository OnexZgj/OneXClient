package com.it.onex.onex;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import com.alibaba.android.arouter.launcher.ARouter;
import com.it.onex.onex.base.BaseActivity;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.ui.fragment.home.HomeFragment;
import com.it.onex.onex.ui.fragment.knowledge.KnowLedgeFragment;
import com.it.onex.onex.ui.fragment.me.MeFragment;
import com.it.onex.onex.ui.fragment.navigation.NavigationFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;

    private List<BaseFragment> mFragments = new ArrayList<>();
    /**
     * 上一次的Fragment实例的索引
     */
    private int mLastFgIndex;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        mNavigation.setOnNavigationItemSelectedListener(this);
        initFragment();
        switchFragment(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuHot) {
            mToolbar.setTitle(R.string.hot_title);

            //TODO 实现热门的Fragment
            switchFragment(2);
        } else if (item.getItemId() == R.id.menuSearch) {
            ARouter.getInstance().build("/hotsearch/SearchActivity").navigation();
        }

        return super.onOptionsItemSelected(item);

    }

    private void initFragment() {
        mFragments.add(HomeFragment.getInstance());
        mFragments.add(KnowLedgeFragment.getInstance());
        mFragments.add(NavigationFragment.getInstance());
        mFragments.add(MeFragment.getInstance());
    }


    private void switchFragment(int position) {
        if (position >= mFragments.size()) {
            return;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        BaseFragment targetFg = mFragments.get(position);
        Fragment lastFg = mFragments.get(mLastFgIndex);
        mLastFgIndex = position;
        ft.hide(lastFg);
        if (!targetFg.isAdded())
            ft.add(R.id.layout_fragment, targetFg);

        ft.show(targetFg);

        //TODO HOW AND WHY?
        ft.commitAllowingStateLoss();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_home:
                mToolbar.setTitle(R.string.app_name);
                switchFragment(0);
                break;
            case R.id.navigation_knowledgesystem:
                mToolbar.setTitle(R.string.knowledgesystem);
                switchFragment(1);
                break;
            case R.id.navigation_navigation:
                mToolbar.setTitle(R.string.navigation);
                switchFragment(2);
                break;
            case R.id.navigation_my:
                mToolbar.setTitle(R.string.my);
                switchFragment(2);
                break;
        }

        return true;
    }
}
