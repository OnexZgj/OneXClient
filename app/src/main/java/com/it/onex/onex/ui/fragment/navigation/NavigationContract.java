package com.it.onex.onex.ui.fragment.navigation;

import com.it.onex.onex.base.BaseContract;
import com.it.onex.onex.bean.Navigation;

import java.util.List;

/**
 * Created by Linsa on 2018/4/17:10:31.
 * des:
 */

public class NavigationContract {

    interface View extends BaseContract.BaseView {

        void setNavigationData(List<Navigation> navigations);

    }

    interface Presenter extends BaseContract.BasePresenter<NavigationContract.View> {

        void loadNavigationData();

    }
}
