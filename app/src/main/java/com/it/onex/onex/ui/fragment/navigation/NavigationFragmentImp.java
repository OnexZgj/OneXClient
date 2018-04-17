package com.it.onex.onex.ui.fragment.navigation;

import com.it.onex.onex.base.BasePresenter;
import com.it.onex.onex.bean.DataResponse;
import com.it.onex.onex.bean.Navigation;
import com.it.onex.onex.net.ApiService;
import com.it.onex.onex.net.RetrofitManager;
import com.it.onex.onex.utils.RxSchedulers;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by OnexZgj on 2018/4/17:10:33.
 * des:导航体系的Presenter
 */

public class NavigationFragmentImp extends BasePresenter<NavigationContract.View> implements NavigationContract.Presenter {

    @Inject
    public NavigationFragmentImp() {
    }

    @Override
    public void loadNavigationData() {
        RetrofitManager.create(ApiService.class)
                .getNavigationContent()
                .compose(RxSchedulers.<DataResponse<List<Navigation>>>applySchedulers())
                .compose(mView.<DataResponse<List<Navigation>>>bindToLife())
                .subscribe(new Consumer<DataResponse<List<Navigation>>>() {
                    @Override
                    public void accept(DataResponse<List<Navigation>> navigationDataResponse) throws Exception {
                        mView.setNavigationData(navigationDataResponse.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showFaild(throwable.getMessage().toString());
                    }
                });
    }

}
