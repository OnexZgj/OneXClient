package com.it.onex.onex.ui.fragment.project;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.bean.Project;
import com.it.onex.onex.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linsa on 2018/4/16:10:52.
 * des:文章类型的PageAdapter
 */

public class ProjectTypePageAdapter extends FragmentPagerAdapter {

    private List<Project> mProjects;
    private List<BaseFragment> mArticleListFragments;

    public ProjectTypePageAdapter(FragmentManager fm, List<Project> projects) {
        super(fm);
        this.mProjects=projects;
        mArticleListFragments=new ArrayList<>();
        if (mProjects==null) return;
        //TODO 待优化解决
        for (int i = 0; i <projects.size() ; i++) {

            ProjectDetailFragment projectDetailFragment = (ProjectDetailFragment) ARouter.getInstance().build( "/project/ProjectDetailFragment")
                    .withInt(Constant.CONTENT_CID_KEY, projects.get(i).getId())
                    .navigation();
            mArticleListFragments.add(projectDetailFragment);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mArticleListFragments.get(position);
    }

    @Override
    public int getCount() {
        return mArticleListFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mProjects.get(position).getName();
    }
}
