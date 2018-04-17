package com.it.onex.onex.ui.fragment.navigation;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * Created by Linsa on 2018/4/16:22:21.
 * des导航体系结构
 */

public class NavigationFragment extends BaseFragment {
    @BindView(R.id.tb_fn_navigation)
    VerticalTabLayout tbFnNavigation;

    @BindView(R.id.rv_fn_content)
    RecyclerView rvFnContent;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_navigation;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView(View view) {

        tbFnNavigation.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public TabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public TabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public TabView.TabTitle getTitle(int position) {
                return null;
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });
    }

    public static NavigationFragment getInstance() {
        return new NavigationFragment();
    }

}
