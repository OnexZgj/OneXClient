package com.it.onex.onex.ui.fragment.article;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.it.onex.onex.bean.KnowledgeSystem;
import com.it.onex.onex.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linsa on 2018/4/16:10:52.
 * des:文章类型的PageAdapter
 */

public class ArticleTypePageAdapter extends FragmentPagerAdapter {

    private List<KnowledgeSystem.ChildrenBean> mChildrenData;
    private List<ArticleListFragment> mArticleListFragments;

    public ArticleTypePageAdapter(FragmentManager fm, List<KnowledgeSystem.ChildrenBean> childrenData) {
        super(fm);
        this.mChildrenData=childrenData;
        mArticleListFragments=new ArrayList<>();
        if (mChildrenData==null) return;
        //TODO 待优化解决
        for (KnowledgeSystem.ChildrenBean childrenBean: mChildrenData) {
            ArticleListFragment articleListFragment = (ArticleListFragment) ARouter.getInstance().build("/article/ArticleListFragment")
                    .withInt(Constant.CONTENT_CID_KEY, childrenBean.getId())
                    .navigation();
            mArticleListFragments.add(articleListFragment);
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
        return mChildrenData.get(position).getName();
    }
}
