package com.it.onex.onex.ui.fragment.article;

import com.it.onex.onex.base.BasePresenter;
import com.it.onex.onex.bean.ArticleTypeContent;
import com.it.onex.onex.bean.DataResponse;
import com.it.onex.onex.constant.LoadType;
import com.it.onex.onex.net.ApiService;
import com.it.onex.onex.net.RetrofitManager;
import com.it.onex.onex.utils.RxSchedulers;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Linsa on 2018/4/16:14:38.
 * des:
 */

public class ArticleFragmentPresenterImp extends BasePresenter<ArticleListFragmentContract.View> implements ArticleListFragmentContract.Presenter {

    private boolean mIsRefresh;
    private int mCid;
    private int mPage=0;

    @Inject
    public ArticleFragmentPresenterImp() {
        this.mIsRefresh = true;
    }

    @Override
    public void loadArticleListData( int cid) {
        this.mCid=cid;
        RetrofitManager.create(ApiService.class)
                .getArticleTypeContent(mPage,cid)
                .compose(RxSchedulers.<DataResponse<ArticleTypeContent>>applySchedulers())
                .compose(mView.<DataResponse<ArticleTypeContent>>bindToLife())
                .subscribe(new Consumer<DataResponse<ArticleTypeContent>>() {
                    @Override
                    public void accept(DataResponse<ArticleTypeContent> articleTypeContentDataResponse) throws Exception {
                        int loadType = mIsRefresh ? LoadType.TYPE_REFRESH_SUCCESS : LoadType.TYPE_LOAD_MORE_SUCCESS;
                        mView.setArticleList(articleTypeContentDataResponse.getData(),loadType);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        int loadType = mIsRefresh ? LoadType.TYPE_REFRESH_ERROR : LoadType.TYPE_LOAD_MORE_ERROR;
                        mView.showFaild(throwable.getMessage().toString());
                    }
                });

    }

    @Override
    public void refresh() {
        mPage=0;
        mIsRefresh=true;
        loadArticleListData(mCid);
    }

    @Override
    public void loadMore() {
        mPage++;
        mIsRefresh = false;
        loadArticleListData(mCid);
    }
}
