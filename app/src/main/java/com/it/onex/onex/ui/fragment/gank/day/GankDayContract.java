package com.it.onex.onex.ui.fragment.gank.day;

import com.it.onex.onex.base.BaseContract;
import com.it.onex.onex.bean.TempGankDayBean;

import java.util.List;

/**
 * Created by Linsa on 2018/5/4:14:37.
 * des:
 */

public interface GankDayContract {

    interface View extends BaseContract.BaseView{
        void showDayData(List<TempGankDayBean> bean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{

        void loadGankDayData();

        void refresh();

    }

}
