package com.it.onex.onex.ui.fragment.hot;

import com.it.onex.onex.base.BasePresenter;
import com.it.onex.onex.bean.DataResponse;
import com.it.onex.onex.bean.Friend;
import com.it.onex.onex.bean.HotKey;
import com.it.onex.onex.constant.Constant;
import com.it.onex.onex.net.ApiService;
import com.it.onex.onex.net.RetrofitManager;
import com.it.onex.onex.utils.RxSchedulers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * Created by  OnexZgj on 2018/4/18:17:17.
 * des:热搜关键字
 */

public class HotFragmentImp extends BasePresenter<HotContract.View> implements HotContract.Presenter {


    @Inject
    public HotFragmentImp() {
    }

    @Override
    public void loadHotData() {
        Observable<DataResponse<List<HotKey>>> hotKeyObservable = RetrofitManager.create(ApiService.class).getHotKey();
        Observable<DataResponse<List<Friend>>> friendLinkObservable = RetrofitManager.create(ApiService.class).getFriendLink();
        Observable.zip(hotKeyObservable, friendLinkObservable, new BiFunction<DataResponse<List<HotKey>>, DataResponse<List<Friend>>, Map<String, Object>>() {
            @Override
            public Map<String, Object> apply(DataResponse<List<HotKey>> hotKeyDataResponse, DataResponse<List<Friend>> friendResponse) throws Exception {
                Map<String ,Object> objMap=new HashMap<>();
                objMap.put(Constant.CONTENT_HOT_KEY, hotKeyDataResponse.getData());
                objMap.put(Constant.CONTENT_HOT_FRIEND_KEY, friendResponse.getData());
                return objMap;
            }
        }).compose(RxSchedulers.<Map<String, Object>>applySchedulers())
                .compose(mView.<Map<String, Object>>bindToLife())
                .subscribe(new Consumer<Map<String, Object>>() {
                    @Override
                    public void accept(Map<String, Object> map) throws Exception {
                        List<HotKey> hotKeys = (List<HotKey>) map.get(Constant.CONTENT_HOT_KEY);
                        List<Friend> friends = (List<Friend>) map.get(Constant.CONTENT_HOT_FRIEND_KEY);
                        mView.setHotData(hotKeys,friends);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showFaild(throwable.getMessage().toString());
                    }
                });


    }

    @Override
    public void refresh() {
        loadHotData();
    }
}
