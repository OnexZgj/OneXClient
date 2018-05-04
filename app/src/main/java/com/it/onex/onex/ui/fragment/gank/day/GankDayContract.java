package com.it.onex.onex.ui.fragment.gank.day;

import com.it.onex.onex.base.BaseContract;
import com.it.onex.onex.bean.GankIoDayBean;

/**
 * Created by Linsa on 2018/5/4:14:37.
 * des:
 */

public interface GankDayContract {

    interface View extends BaseContract.BaseView{
        void showDayListData(GankIoDayBean data);
    }

    interface Presenter extends BaseContract.BasePresenter{

        /**
         * 加载每日数据
         * @param year 年
         * @param month 月
         * @param day 日
         */
        void loadDayData(String year,String month,String day);


        /**
         * 刷新
         */
        void refresh();

    }

}
