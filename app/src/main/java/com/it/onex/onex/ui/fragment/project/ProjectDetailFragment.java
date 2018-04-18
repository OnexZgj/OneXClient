package com.it.onex.onex.ui.fragment.project;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.bean.ProjectDetail;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Linsa on 2018/4/16:10:57.
 * des:完整项目vp中的Fragment
 */

@Route(path = "/project/ProjectDetailFragment")
public class ProjectDetailFragment extends BaseFragment<ProjectDetailFragmentImp> implements ProjectDetailFragmentContract.View, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.RequestLoadMoreListener {


    @BindView(R.id.rv_fpl_project_list)
    RecyclerView rvFplProjectList;
    @BindView(R.id.srl_fpl_refresh)
    SwipeRefreshLayout srlFplRefresh;

    @Inject
    ProjectDetailAdapter mAdapter;

    @Autowired
    int cid;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project_list;
    }

    @Override
    protected void initInjector() {
        mFragmentComponent.inject(this);
    }

    @Override
    protected void initView(View view) {
        srlFplRefresh.setOnRefreshListener(this);
        rvFplProjectList.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnLoadMoreListener(this);

        mPresenter.loadProjectInfoData(cid);
    }

    @Override
    public void setProjectData(ProjectDetail projectDetail, int loadType) {
        setLoadDataResult(mAdapter,srlFplRefresh,projectDetail.getDatas(),loadType);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }


    @Override
    public void onRefresh() {
        mPresenter.refresh();
    }


    @Override
    public void onLoadMoreRequested() {
        mPresenter.loadMore();
    }


}
