package com.it.onex.onex.ui.fragment.article;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Linsa on 2018/4/16:10:57.
 * des:知识体系结构的二级跟目录
 */

@Route(path = "/article/ArticleListFragment")
public class ArticleListFragment extends BaseFragment {

    @BindView(R.id.rv_fal_content_list)
    RecyclerView rvFalContentList;
    @BindView(R.id.srl_fal_refresh)
    SwipeRefreshLayout srlFalRefresh;
    @Autowired
    String cid;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_article_list;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView(View view) {

    }
}
