package com.it.onex.onex.ui.fragment.project;

import android.view.View;

import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.bean.Project;

import java.util.List;

import butterknife.BindView;
import cn.youngkaaa.yviewpager.YViewPager;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * Created by Linsa on 2018/4/17:14:20.
 * des:
 */

public class ProjectFragment extends BaseFragment<ProjectFragmentImp> implements ProjectContract.View {
    @BindView(R.id.tb_fn_project)
    VerticalTabLayout tbFnProject;
    @BindView(R.id.vp_fp_content)
    YViewPager vpFpContent;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    protected void initInjector() {
        mFragmentComponent.inject(this);
    }

    @Override
    protected void initView(View view) {
        mPresenter.loadProjectNavigationData();
    }

    @Override
    public void setProjectNavigationData(final List<Project> projects) {
        tbFnProject.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return projects.size();
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
                        .setContent(projects.get(i).getName())
                        .setTextColor(0xFF36BC9B, 0xFF757575)
                        .build();
            }


            @Override
            public int getBackground(int position) {
                return -1;
            }
        });




        vpFpContent.setAdapter(new ProjectTypePageAdapter(getChildFragmentManager(),projects));

        tbFnProject.setupWithViewPager(vpFpContent);

    }

    public static BaseFragment getInstance() {
        return  new ProjectFragment();
    }
}
