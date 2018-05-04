package com.it.onex.onex.ui.fragment.gank.welfare;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.bean.GankIoWelfareListBean;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by OnexZgj on 2018/5/3:17:15.
 * des:干货福利Fragment
 */

public class GankWelFareFragment extends BaseFragment<GankWelFarePresenterImp> implements GankWelFareContract.View, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.rv_gankio_welfare)
    RecyclerView rvGankioWelfare;
    @BindView(R.id.srl_fgiw_welfare)
    SwipeRefreshLayout srlFgiwWelfare;

    @Inject
    WelFareAdapter mAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank_io_welfare;
    }

    @Override
    protected void initInjector() {
        mFragmentComponent.inject(this);
    }

    @Override
    protected void initView(View view) {

        srlFgiwWelfare.setOnRefreshListener(this);


        rvGankioWelfare.setLayoutManager(new LinearLayoutManager(getParentFragment().getContext()));

        rvGankioWelfare.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnLoadMoreListener(this);

        mPresenter.loadWelFareData();
    }


    @Override
    public void showWelFareData(GankIoWelfareListBean data, int loadType) {
        setLoadDataResult(mAdapter,srlFgiwWelfare,data.getResults(),loadType);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.loadMore();
    }

    @Override
    public void onRefresh() {
        mPresenter.refresh();
    }

    public static GankWelFareFragment  getInstance() {
        return new GankWelFareFragment();
    }
}
