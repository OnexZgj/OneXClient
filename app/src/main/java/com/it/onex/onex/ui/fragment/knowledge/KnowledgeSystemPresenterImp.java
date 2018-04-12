package com.it.onex.onex.ui.fragment.knowledge;

import com.it.onex.onex.base.BasePresenter;
import com.it.onex.onex.bean.DataResponse;
import com.it.onex.onex.bean.KnowledgeSystem;
import com.it.onex.onex.net.ApiService;
import com.it.onex.onex.net.RetrofitManager;
import com.it.onex.onex.utils.RxSchedulers;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Linsa on 2018/4/12:22:43.
 * des:
 */

public class KnowledgeSystemPresenterImp extends BasePresenter<KnowledgeSystemContract.View> implements KnowledgeSystemContract.Presenter {


    @Inject
    public KnowledgeSystemPresenterImp() {
    }

    @Override
    public void loadKnowledgeSystems() {
        RetrofitManager.create(ApiService.class)
                .getKnowledgeSystemTree()
                .compose(RxSchedulers.<DataResponse<List<KnowledgeSystem>>>applySchedulers())
                .compose(mView.<DataResponse<List<KnowledgeSystem>>>bindToLife())
                .subscribe(new Consumer<DataResponse<List<KnowledgeSystem>>>() {
                    @Override
                    public void accept(DataResponse<List<KnowledgeSystem>> dataResponse) throws Exception {
                        mView.setKnowledgeSystems(dataResponse.getData());
                    }

                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showFaild("请求网络数据错误!");
                    }
                });
    }

    @Override
    public void refresh() {
        loadKnowledgeSystems();
    }
}
