package com.it.onex.onex.ui.fragment.navigation;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.bean.Navigation;

import java.util.List;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * Created by Linsa on 2018/4/16:22:21.
 * des导航体系结构
 */

public class NavigationFragment extends BaseFragment<NavigationFragmentImp> implements NavigationContract.View {
    @BindView(R.id.tb_fn_navigation)
    VerticalTabLayout tbFnNavigation;

    @BindView(R.id.rv_fn_content)
    RecyclerView rvFnContent;

    private List<Navigation> mNavigation;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_navigation;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView(View view) {
        rvFnContent.setLayoutManager(new LinearLayoutManager(getContext()));
        mPresenter.loadNavigationData();

    }

    public static NavigationFragment getInstance() {
        return new NavigationFragment();
    }

    @Override
    public void setNavigationData(final List<Navigation> navigation) {
        this.mNavigation=navigation;
        //这块进行设置adapter
        tbFnNavigation.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return navigation.size();
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
            public ITabView.TabTitle getTitle(int i) {
                return new TabView.TabTitle.Builder()
                        .setContent(navigation.get(i).getName())
                        .setTextColor(0xFF36BC9B, 0xFF757575)
                        .build();
            }


            @Override
            public int getBackground(int position) {
                return -1;
            }
        });

        //设置recycleView的adapter
    }
}
