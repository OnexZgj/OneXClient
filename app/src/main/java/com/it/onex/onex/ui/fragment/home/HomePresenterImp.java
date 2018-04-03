package com.it.onex.onex.ui.fragment.home;

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
 * Created by Linsa on 2018/4/3:11:03.
 * des:
 */

public class HomePresenterImp extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    private int mPage=0;


    private boolean mIsRefresh;
//
    @Inject
    public HomePresenterImp() {
        this.mIsRefresh = true;
    }


    @Override
    public void loadHomeBanners() {

    }

    @Override
    public void loadHomeArticles() {
        RetrofitManager.create(ApiService.class)
                .getHomeArticles(mPage)
                .compose(RxSchedulers.<DataResponse<Article>>applySchedulers())
                .compose(mView.<DataResponse<Article>>bindToLife())
                .subscribe(new Consumer<DataResponse<Article>>() {
                    @Override
                    public void accept(DataResponse<Article> dataResponse) throws Exception {
//                        int loadType = mIsRefresh ? LoadType.TYPE_REFRESH_SUCCESS : LoadType.TYPE_LOAD_MORE_SUCCESS;

                        mView.setHomeArticles(dataResponse.getData(), LoadType.TYPE_REFRESH_SUCCESS);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.setHomeArticles(new Article(), LoadType.TYPE_REFRESH_ERROR);
                    }
                });
    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void collectArticle(int position, Article.DatasBean bean) {

    }

    @Override
    public void loadHomeData() {

    }
}
