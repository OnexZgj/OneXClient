package com.it.onex.onex.ui.fragment.gank.welfare;

import android.content.Context;
import android.os.Environment;

import com.blankj.utilcode.util.FileUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.it.onex.onex.base.BasePresenter;
import com.it.onex.onex.bean.GankIoWelfareListBean;
import com.it.onex.onex.constant.LoadType;
import com.it.onex.onex.net.GankioApi;
import com.it.onex.onex.net.RetrofitManager;
import com.it.onex.onex.utils.RxSchedulers;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

/**
 * Created by OnexZgj on 2018/5/4:09:41.
 * des:
 */

public class GankWelFarePresenterImp extends BasePresenter<GankWelFareContract.View> implements GankWelFareContract.Presenter {


    private int count = 20;
    private int mPage = 1;

    /**
     * 第一次进来是刷新的逻辑
     */
    private boolean mIsRefresh = true;


    @Inject
    public GankWelFarePresenterImp() {

    }

    @Override
    public void loadWelFareData() {
        RetrofitManager.createGankIo(GankioApi.class)
                .getGankIoWelfareList(count, mPage)
                .compose(mView.<GankIoWelfareListBean>bindToLife())
                .compose(RxSchedulers.<GankIoWelfareListBean>applySchedulers())
                .subscribe(new Consumer<GankIoWelfareListBean>() {
                    @Override
                    public void accept(GankIoWelfareListBean gankIoWelfareListBean) throws Exception {
                        int loadType = mIsRefresh ? LoadType.TYPE_REFRESH_SUCCESS : LoadType.TYPE_LOAD_MORE_SUCCESS;
                        mView.showWelFareData(gankIoWelfareListBean, loadType);
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
        mIsRefresh = true;
        mPage = 1;
        loadWelFareData();
    }

    @Override
    public void loadMore() {
        mIsRefresh = false;
        mPage++;
        loadWelFareData();
    }

    @Override
    public void saveImageToLocal(final Context context, final String imgUrl) {

        Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                File source = Glide.with(context).load(imgUrl).downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).get();

                String[] split = imgUrl.split("/");
                String imageName = split[split.length - 1];

                boolean isSaveSuccess = FileUtils.copyFile(source, new File(Environment.getExternalStorageDirectory() + "/onexpic/" + imageName), new FileUtils.OnReplaceListener() {
                    @Override
                    public boolean onReplace() {
                        return false;
                    }
                });

                emitter.onNext(isSaveSuccess);
            }
        }).compose(RxSchedulers.applySchedulers())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object aBoolean) throws Exception {
                        boolean isSaveSuccess = (boolean) aBoolean;
                        if (isSaveSuccess) {
                            String[] split = imgUrl.split("/");
                            String imageName = split[split.length - 1];
                            mView.showSuccess("图片以保存到:"+Environment.getExternalStorageDirectory() + "/onexpic/" + imageName);
                        } else {
                            mView.showSuccess("图片保存失败");
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showFaild(throwable.getMessage().toString());
                    }
                });
    }

}
