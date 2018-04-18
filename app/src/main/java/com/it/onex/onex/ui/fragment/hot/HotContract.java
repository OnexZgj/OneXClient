package com.it.onex.onex.ui.fragment.hot;

import com.it.onex.onex.base.BaseContract;
import com.it.onex.onex.bean.Friend;
import com.it.onex.onex.bean.HotKey;

import java.util.List;

/**
 * Created by Linsa on 2018/4/17:10:31.
 * des:
 */

public class HotContract {

    interface View extends BaseContract.BaseView {
        void setHotData(List<HotKey> hotKeys, List<Friend> friends);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void loadHotData();

        void refresh();
    }
}
