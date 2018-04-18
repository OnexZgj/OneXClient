package com.it.onex.onex.ui.fragment.hot;

import com.it.onex.onex.base.BasePresenter;
import com.it.onex.onex.bean.DataResponse;
import com.it.onex.onex.bean.Friend;
import com.it.onex.onex.bean.HotKey;
import com.it.onex.onex.net.ApiService;
import com.it.onex.onex.net.RetrofitManager;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Linsa on 2018/4/18:17:17.
 * des:
 */

public class HotFragmentImp extends BasePresenter<HotContract.View> implements HotContract.Presenter {
    @Override
    public void loadHotData() {
        Observable<DataResponse<List<HotKey>>> hotKeyObservable = RetrofitManager.create(ApiService.class).getHotKey();
        Observable<DataResponse<List<Friend>>> friendLinkObservable = RetrofitManager.create(ApiService.class).getFriendLink();



    }

    @Override
    public void refresh() {
        loadHotData();
    }
}
