package com.it.onex.onex.ui.fragment.gank.custom;

import com.it.onex.onex.base.BaseContract;

/**
 * Created by Linsa on 2018/5/7:17:23.
 * des:
 */

public interface GankCustomContract {
    interface View extends BaseContract.BaseView{
        void showCustomeData();
    }

    interface Presenter extends BaseContract.BasePresenter{

        void loadCustomeData();
        void refresh();
        void loadMore();
    }
}
