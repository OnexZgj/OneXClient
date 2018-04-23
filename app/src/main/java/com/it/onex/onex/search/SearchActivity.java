package com.it.onex.onex.search;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseActivity;
import com.it.onex.onex.bean.Article;
import com.it.onex.onex.ui.fragment.article.ArticleAdapter;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 搜索关键界面的Activity
 *
 * @author OnexZgj
 * @time 2018/04/19
 */

@Route(path = "/hotsearch/SearchActivity")
public class SearchActivity extends BaseActivity<SearchPresenterImp> implements SearchContract.View, BaseQuickAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnItemChildClickListener, BaseQuickAdapter.RequestLoadMoreListener {


    @BindView(R.id.rv_as_list)
    RecyclerView rvAsList;
    @BindView(R.id.swl_as_refresh)
    SwipeRefreshLayout swlAsRefresh;
    private SearchView mSearchView;

    @Inject
    ArticleAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initInjector() {
        mActivityComponent.inject(this);
    }

    @Override
    protected void initView() {
        /**设置RecyclerView*/
        rvAsList.setLayoutManager(new LinearLayoutManager(this));
        rvAsList.setAdapter(mAdapter);

        /**设置事件监听*/
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemChildClickListener(this);
        swlAsRefresh.setOnRefreshListener(this);
        mAdapter.setOnLoadMoreListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
//        MenuItem searchItem = menu.findItem(R.id.menuSearch);
        mSearchView = (SearchView) menu.findItem(R.id.menuSearch).getActionView();
        //射进默认进去就是搜索
        mSearchView.setIconified(false);
        //设置搜索图标在框中显示
//        mSearchView.setIconifiedByDefault(false);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                mPresenter.loadSearchArtcles(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    protected boolean showHomeAsUp() {
        return true;
    }

    @Override
    public void setSearchArtcles(Article article, int loadType) {
        setLoadDataResult(mAdapter,swlAsRefresh,article.getDatas(),loadType);
    }

    @Override
    public void collectArticleSuccess(int position, Article.DatasBean bean) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onRefresh() {
        mPresenter.refresh();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onLoadMoreRequested() {

    }
}
