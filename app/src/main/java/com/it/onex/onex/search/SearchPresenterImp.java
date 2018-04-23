package com.it.onex.onex.search;

import com.it.onex.onex.base.BasePresenter;
import com.it.onex.onex.bean.Article;
import com.it.onex.onex.bean.DataResponse;
import com.it.onex.onex.constant.LoadType;
import com.it.onex.onex.net.ApiService;
import com.it.onex.onex.net.RetrofitManager;
import com.it.onex.onex.utils.RxSchedulers;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Linsa on 2018/4/23:21:51.
 * des:
 */

public class SearchPresenterImp extends BasePresenter<SearchContract.View> implements SearchContract.Presenter {

    private int page=0;
    private boolean mIsRefresh;
    private String mK;

    @Inject
    public SearchPresenterImp() {

    }

    @Override
    public void loadSearchArtcles(String k) {
        this.mK = k;
        RetrofitManager.create(ApiService.class)
                .getSearchArticles(page,k)
                .compose(mView.<DataResponse<Article>>bindToLife())
                .compose(RxSchedulers.<DataResponse<Article>>applySchedulers())
                .subscribe(new Consumer<DataResponse<Article>>() {
                    @Override
                    public void accept(DataResponse<Article> articleDataResponse) throws Exception {
                        int loadType = mIsRefresh ? LoadType.TYPE_REFRESH_SUCCESS : LoadType.TYPE_LOAD_MORE_SUCCESS;
                        mView.setSearchArtcles(articleDataResponse.getData(),loadType);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showFaild(throwable.getMessage().toString());
                    }
                });
    }

    @Override
    public void refresh() {
        page=0;
        loadSearchArtcles(mK);
    }

    @Override
    public void loadMore() {
        page++;
        loadSearchArtcles(mK);

    }

    @Override
    public void collectArticle(int position, Article.DatasBean bean) {

    }

    @Override
    public void loadHistory() {

    }

    @Override
    public void addHistory(String name) {

    }
}
