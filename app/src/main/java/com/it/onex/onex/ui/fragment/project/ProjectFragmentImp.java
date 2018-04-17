package com.it.onex.onex.ui.fragment.project;

import com.it.onex.onex.base.BasePresenter;
import com.it.onex.onex.bean.DataResponse;
import com.it.onex.onex.bean.Project;
import com.it.onex.onex.net.ApiService;
import com.it.onex.onex.net.RetrofitManager;
import com.it.onex.onex.utils.RxSchedulers;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Linsa on 2018/4/17:14:55.
 * des:
 */

public class ProjectFragmentImp extends BasePresenter<ProjectContract.View> implements ProjectContract.Presenter {

    @Inject
    public ProjectFragmentImp() {
    }

    @Override
    public void loadProjectNavigationData() {
        RetrofitManager.create(ApiService.class)
                .getProjectData()
                .compose(RxSchedulers.<DataResponse<List<Project>>>applySchedulers())
                .compose(mView.<DataResponse<List<Project>>>bindToLife())
                .subscribe(new Consumer<DataResponse<List<Project>>>() {
                    @Override
                    public void accept(DataResponse<List<Project>> listDataResponse) throws Exception {
                        mView.setProjectNavigationData(listDataResponse.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showFaild(throwable.getMessage().toString());
                    }
                });

    }
}
