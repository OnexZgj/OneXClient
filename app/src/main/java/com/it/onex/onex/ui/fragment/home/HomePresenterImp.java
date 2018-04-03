package com.it.onex.onex.ui.fragment.home;

import com.it.onex.onex.base.BasePresenter;
import com.it.onex.onex.bean.Article;
import com.it.onex.onex.bean.BannerData;
import com.it.onex.onex.bean.DataResponse;
import com.it.onex.onex.constant.Constant;
import com.it.onex.onex.constant.LoadType;
import com.it.onex.onex.net.ApiService;
import com.it.onex.onex.net.RetrofitManager;
import com.it.onex.onex.utils.RxSchedulers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * Created by Linsa on 2018/4/3:11:03.
 * des:
 */

public class HomePresenterImp extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    private int mPage = 0;


    private boolean mIsRefresh;

    //
    @Inject
    public HomePresenterImp() {
        this.mIsRefresh = true;
    }


    @Override
    public void loadHomeBanners() {
        RetrofitManager.create(ApiService.class)
                .getHomeBanners()
                .compose(RxSchedulers.<DataResponse<List<BannerData>>>applySchedulers())
                .compose(mView.<DataResponse<List<BannerData>>>bindToLife())
                .subscribe(new Consumer<DataResponse<List<BannerData>>>() {
                    @Override
                    public void accept(DataResponse<List<BannerData>> listDataResponse) throws Exception {
                        mView.setHomeBanners(listDataResponse.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showFaild("请求网络数据错误!");
                    }
                });

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
                        int loadType = mIsRefresh?LoadType.TYPE_REFRESH_SUCCESS:LoadType.TYPE_LOAD_MORE_SUCCESS;

                        mView.setHomeArticles(dataResponse.getData(),loadType);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        int loadType = mIsRefresh?LoadType.TYPE_REFRESH_ERROR:LoadType.TYPE_LOAD_MORE_ERROR;
                        mView.setHomeArticles(new Article(),loadType);
                    }
                });
    }

    @Override
    public void refresh() {
        mPage = 0;
        mIsRefresh = true;
        loadHomeBanners();
        loadHomeArticles();
    }

    @Override
    public void loadMore() {
        mPage++;
        mIsRefresh = false;
        loadHomeArticles();
    }

    @Override
    public void collectArticle(int position, Article.DatasBean bean) {

    }

    @Override
    public void loadHomeData() {
        ApiService apiService = RetrofitManager.create(ApiService.class);
        Observable<DataResponse<Article>> observableArticle = apiService.getHomeArticles(mPage);
        Observable<DataResponse<List<BannerData>>> observableBanner = apiService.getHomeBanners();

        Observable.zip(observableArticle, observableBanner, new BiFunction<DataResponse<Article>, DataResponse<List<BannerData>>, Map<String, Object>>() {
            @Override
            public Map<String, Object> apply(DataResponse<Article> articleDataResponse, DataResponse<List<BannerData>> bannerDataResponse) throws Exception {
                Map<String, Object> objMap = new HashMap<>();
                objMap.put(Constant.BANNER_KEY, bannerDataResponse.getData());
                objMap.put(Constant.ARTICLE_KEY, articleDataResponse.getData());
                return objMap;
            }
        }).compose(RxSchedulers.<Map<String, Object>>applySchedulers())
                .compose(mView.<Map<String, Object>>bindToLife())
                .subscribe(new Consumer<Map<String, Object>>() {
                    @Override
                    public void accept(Map<String, Object> dataMap) throws Exception {
                        mView.setHomeBanners((List<BannerData>) dataMap.get(Constant.BANNER_KEY));
                        mView.setHomeArticles((Article) dataMap.get(Constant.ARTICLE_KEY), LoadType.TYPE_REFRESH_SUCCESS);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showFaild("请求网络错误" + throwable.getMessage());
                    }
                });

    }
}
