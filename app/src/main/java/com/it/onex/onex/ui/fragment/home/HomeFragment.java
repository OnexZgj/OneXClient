package com.it.onex.onex.ui.fragment.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.bean.Article;
import com.it.onex.onex.bean.BannerData;
import com.it.onex.onex.ui.fragment.article.ArticleAdapter;
import com.it.onex.onex.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by OnexZgj on 2018/4/2:22:08.
 * des:
 */

public class HomeFragment extends BaseFragment<HomePresenterImp> implements HomeContract.View, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemChildClickListener, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rvHomeArticles)
    RecyclerView rvHomeArticles;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    ArticleAdapter mArticleAdapter;
    private View mHomeBannerHeadView;
    private Banner mBannerAds;

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initInjector() {
        mFragmentComponent.inject(this);
    }

    @Override
    protected void initView(View view) {
        rvHomeArticles.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHomeArticles.setAdapter(mArticleAdapter);


        /**设置BannerHeadView*/
        mHomeBannerHeadView = LayoutInflater.from(getContext()).inflate(R.layout.layout_home_banner_head, null);
        mBannerAds = mHomeBannerHeadView.findViewById(R.id.banner_ads);
        mArticleAdapter.addHeaderView(mHomeBannerHeadView);

        /**设置事件监听*/
        mArticleAdapter.setOnItemClickListener(this);
        mArticleAdapter.setOnItemChildClickListener(this);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mArticleAdapter.setOnLoadMoreListener(this);

        //请求数据
        mPresenter.loadHomeData();
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
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onRefresh() {
        mPresenter.refresh();
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.loadMore();
    }

    @Override
    public void setHomeBanners(final List<BannerData> banners) {
        ArrayList<String> titles=new ArrayList<>();
        ArrayList<String> imageUrls=new ArrayList<>();

        for (BannerData data: banners) {
            titles.add(data.getTitle());
            imageUrls.add(data.getImagePath());
        }
        mBannerAds.setImages(imageUrls)
                .setBannerTitles(titles)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setImageLoader(new GlideImageLoader())
                .setBannerAnimation(Transformer.ZoomIn)
                .start();
        mBannerAds.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                ARouter.getInstance().build("/article/ArticleContentActivity")
                        .withInt("id",banners.get(position).getId())
                        .withString("url",banners.get(position).getUrl())
                        .withString("title",banners.get(position).getTitle())
                        .withString("author",null)
                        .navigation();
            }
        });
    }

    @Override
    public void setHomeArticles(Article article, int loadType) {
        setLoadDataResult(mArticleAdapter, mSwipeRefreshLayout, article.getDatas(), loadType);
    }

    @Override
    public void collectArticleSuccess(int position, Article.DatasBean bean) {

    }
}
