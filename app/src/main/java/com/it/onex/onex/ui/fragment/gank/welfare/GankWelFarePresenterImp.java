package com.it.onex.onex.ui.fragment.gank.welfare;

import com.it.onex.onex.base.BasePresenter;
import com.it.onex.onex.bean.GankIoWelfareListBean;
import com.it.onex.onex.constant.LoadType;
import com.it.onex.onex.net.GankioApi;
import com.it.onex.onex.net.RetrofitManager;
import com.it.onex.onex.utils.RxSchedulers;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by OnexZgj on 2018/5/4:09:41.
 * des:
 */

public class GankWelFarePresenterImp extends BasePresenter<GankWelFareContract.View> implements GankWelFareContract.Presenter {


    private int count=20;
    private int mPage=1 ;

    /**
     * 第一次进来是刷新的逻辑
     */
    private boolean mIsRefresh=true;


    @Inject
    public GankWelFarePresenterImp() {

    }

    @Override
    public void loadWelFareData() {
        RetrofitManager.createGankIo(GankioApi.class)
                .getGankIoWelfareList(count,mPage)
                .compose(mView.<GankIoWelfareListBean>bindToLife())
                .compose(RxSchedulers.<GankIoWelfareListBean>applySchedulers())
                .subscribe(new Consumer<GankIoWelfareListBean>() {
                    @Override
                    public void accept(GankIoWelfareListBean gankIoWelfareListBean) throws Exception {
                        int loadType = mIsRefresh ? LoadType.TYPE_REFRESH_SUCCESS : LoadType.TYPE_LOAD_MORE_SUCCESS;
                        mView.showWelFareData(gankIoWelfareListBean,loadType);
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
        mPage=1;
        loadWelFareData();
    }

    @Override
    public void loadMore() {
        mIsRefresh=false;
        mPage++;
        loadWelFareData();
    }
}
