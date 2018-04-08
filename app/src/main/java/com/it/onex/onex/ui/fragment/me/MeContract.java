package com.it.onex.onex.ui.fragment.me;


import com.it.onex.onex.base.BaseContract;
import com.it.onex.onex.bean.User;

/**
 * Created by OnexZgj on 2018/4/8.
 */

public interface MeContract {

    interface View extends BaseContract.BaseView {
        void loginSuccess(User user);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void login(String username, String password);
    }
}
