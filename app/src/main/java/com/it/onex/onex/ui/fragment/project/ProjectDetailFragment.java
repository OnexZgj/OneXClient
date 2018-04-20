package com.it.onex.onex.ui.fragment.project;

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
 * Created by OnexZgj on 2018/4/16:10:57.
 * des:完整项目vp中的Fragment
 */

@Route(path = "/project/ProjectDetailFragment")
public class ProjectDetailFragment extends BaseFragment<ProjectDetailFragmentImp> implements ProjectDetailFragmentContract.View, BaseQuickAdapter.OnItemClickListener{


    @BindView(R.id.rv_fpl_project_list)
    RecyclerView rvFplProjectList;

    @Inject
    ProjectDetailAdapter mAdapter;

    @Autowired
    int cid;


    public static ProjectDetailFragment getInstance(){
        return new ProjectDetailFragment();
    }

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

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        rvFplProjectList.setLayoutManager(mLayoutManager);
        mAdapter.setOnItemClickListener(this);
        mPresenter.loadProjectInfoData(cid);
    }

    @Override
    public void setProjectData(ProjectDetail projectDetail, int loadType) {
        mAdapter.setNewData(projectDetail.getDatas());
        rvFplProjectList.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        showFaild("onItemClick: " +position);
    }


}
