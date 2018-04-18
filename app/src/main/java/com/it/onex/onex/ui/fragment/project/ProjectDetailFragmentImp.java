package com.it.onex.onex.ui.fragment.project;

import com.it.onex.onex.base.BasePresenter;
import com.it.onex.onex.bean.DataResponse;
import com.it.onex.onex.bean.ProjectDetail;
import com.it.onex.onex.constant.LoadType;
import com.it.onex.onex.net.ApiService;
import com.it.onex.onex.net.RetrofitManager;
import com.it.onex.onex.utils.RxSchedulers;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Linsa on 2018/4/17:15:49.
 * des:
 */

public class ProjectDetailFragmentImp extends BasePresenter<ProjectDetailFragmentContract.View> implements ProjectDetailFragmentContract.Presenter {

    private boolean mIsRefresh;
    private int mPage = 1;

    @Inject
    public ProjectDetailFragmentImp() {

        this.mIsRefresh = true;

    }

    @Override
    public void loadProjectInfoData(int cid) {
        RetrofitManager.create(ApiService.class)
                .getProjectDetailInfo(mPage, cid)
                .compose(RxSchedulers.<DataResponse<ProjectDetail>>applySchedulers())
                .compose(mView.<DataResponse<ProjectDetail>>bindToLife())
                .subscribe(new Consumer<DataResponse<ProjectDetail>>() {
                    @Override
                    public void accept(DataResponse<ProjectDetail> listDataResponse) throws Exception {
                        int loadType = mIsRefresh ? LoadType.TYPE_REFRESH_SUCCESS : LoadType.TYPE_LOAD_MORE_SUCCESS;
                        mView.setProjectData(listDataResponse.getData(), loadType);
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

    }

    @Override
    public void loadMore() {

    }
}
