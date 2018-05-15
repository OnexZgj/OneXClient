package com.it.onex.onex.ui.fragment.gank.custom;

import com.it.onex.onex.base.BasePresenter;
import com.it.onex.onex.bean.GankIoCustomListBean;
import com.it.onex.onex.constant.LoadType;
import com.it.onex.onex.net.GankioApi;
import com.it.onex.onex.net.RetrofitManager;
import com.it.onex.onex.utils.RxSchedulers;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Linsa on 2018/5/14:14:18.
 * des:
 */

public class GankCustomPresenterImp extends BasePresenter<GankCustomContract.View> implements GankCustomContract.Presenter {


    private int mPage=0;
    private boolean mIsRefresh=true;

    @Inject
    public GankCustomPresenterImp() {

    }

    @Override
    public void loadCustomeData() {
        RetrofitManager.createGankIo(GankioApi.class).getGankIoCustomList(mView.getType(),20,mPage)
                .compose(mView.<GankIoCustomListBean>bindToLife())
                .compose(RxSchedulers.<GankIoCustomListBean>applySchedulers())
                .subscribe(new Consumer<GankIoCustomListBean>() {
                    @Override
                    public void accept(GankIoCustomListBean gankIoCustomListBean) throws Exception {
                        int loadType = mIsRefresh ? LoadType.TYPE_REFRESH_SUCCESS : LoadType.TYPE_LOAD_MORE_SUCCESS;
                        mView.showCustomeData(gankIoCustomListBean.getResults(),loadType);
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
        mIsRefresh=true;
        mPage=0;
        loadCustomeData();
    }

    @Override
    public void loadMore() {
        mIsRefresh=false;
        mPage++;
        loadCustomeData();
    }
}
