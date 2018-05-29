package com.it.onex.onex.ui.fragment.article;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.bean.ArticleTypeContent;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Linsa on 2018/4/16:10:57.
 * des:知识体系结构的二级跟目录
 */

@Route(path = "/article/ArticleListFragment")
public class ArticleListFragment extends BaseFragment<ArticleFragmentPresenterImp> implements ArticleListFragmentContract.View, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_fal_content_list)
    RecyclerView rvFalContentList;
    @BindView(R.id.srl_fal_refresh)
    SwipeRefreshLayout srlFalRefresh;

    @Autowired
    int cid;

    @Inject
    ArticleTypeAdapter mArticleAdapter;



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_article_list;
    }

    @Override
    protected void initInjector() {
        mFragmentComponent.inject(this);
    }

    @Override
    protected void initView(View view) {
        rvFalContentList.setLayoutManager(new LinearLayoutManager(getContext()));
        srlFalRefresh.setOnRefreshListener(this);
        rvFalContentList.setAdapter(mArticleAdapter);
        mArticleAdapter.setOnItemClickListener(this);
        mArticleAdapter.setOnLoadMoreListener(this);

        mPresenter.loadArticleListData(cid);

    }

    @Override
    public void setArticleList(ArticleTypeContent articleList,int loadType) {
        setLoadDataResult(mArticleAdapter, srlFalRefresh, articleList.getDatas(), loadType);
    }

    @Override
    public void onRefresh() {
        mPresenter.refresh();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        ARouter.getInstance().build("/article/ArticleContentActivity")
                .withInt("id",mArticleAdapter.getItem(position).getId())
                .withString("url",mArticleAdapter.getItem(position).getLink())
                .withString("title",mArticleAdapter.getItem(position).getTitle())
                .withString("author",mArticleAdapter.getItem(position).getAuthor())
                .navigation();
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.loadMore();
    }
}
