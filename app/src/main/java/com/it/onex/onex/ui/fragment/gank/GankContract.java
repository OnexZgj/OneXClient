package com.it.onex.onex.ui.fragment.gank;


import com.it.onex.onex.base.BaseContract;
import com.it.onex.onex.bean.User;

/**
 * Created by OnexZgj on 2018/4/8.
 */

public interface GankContract {

    interface View extends BaseContract.BaseView {
        void loginSuccess(User user);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void login(String username, String password);
    }
}
