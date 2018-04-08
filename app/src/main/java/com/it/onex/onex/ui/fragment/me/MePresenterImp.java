package com.it.onex.onex.ui.fragment.me;

import com.it.onex.onex.base.BasePresenter;
import com.it.onex.onex.bean.DataResponse;
import com.it.onex.onex.bean.User;
import com.it.onex.onex.net.ApiService;
import com.it.onex.onex.net.RetrofitManager;
import com.it.onex.onex.utils.RxSchedulers;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Linsa on 2018/4/8:22:18.
 * des:
 */

public class MePresenterImp extends BasePresenter<MeContract.View> implements MeContract.Presenter {


    @Inject
    public MePresenterImp() {
    }

    @Override
    public void login(String username, String password) {
        mView.showLoading();
        RetrofitManager.create(ApiService.class)
                .login(username, password)
                .compose(RxSchedulers.<DataResponse<User>>applySchedulers())
                .compose(mView.<DataResponse<User>>bindToLife())
                .subscribe(new Consumer<DataResponse<User>>() {
                    @Override
                    public void accept(DataResponse<User> dataResponse) throws Exception {
                        if (dataResponse.getErrorCode()==0){
                            mView.loginSuccess(dataResponse.getData());
                        }else{
                            mView.showFaild(dataResponse.getErrorMsg());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showFaild(throwable.getMessage());
                    }
                });
    }
}
