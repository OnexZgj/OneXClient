package com.it.onex.onex.ui.fragment.gank.custom;

import com.it.onex.onex.base.BaseContract;
import com.it.onex.onex.bean.GankIoCustomItemBean;

import java.util.List;

/**
 * Created by Linsa on 2018/5/7:17:23.
 * des:
 */

public interface GankCustomContract {
    interface View extends BaseContract.BaseView{
        void showCustomeData(List<GankIoCustomItemBean> gankIoCustomListBean, int loadType);

        /**
         * 获取分类的类型
         * @return
         */
        String getType();
    }

    interface Presenter extends BaseContract.BasePresenter<GankCustomContract.View>{

        void loadCustomeData();
        void refresh();
        void loadMore();
    }
}
