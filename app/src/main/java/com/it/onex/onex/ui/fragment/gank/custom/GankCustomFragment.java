package com.it.onex.onex.ui.fragment.gank.custom;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.bean.GankIoCustomItemBean;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by OnexZgj on 2018/5/3:17:15.
 * des:干货分类Fragment
 */

public class GankCustomFragment extends BaseFragment<GankCustomPresenterImp> implements GankCustomContract.View, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.rv_fc_custom)
    RecyclerView rvFcCustom;
    @BindView(R.id.srl_fc_custome)
    SwipeRefreshLayout srlFcCustome;

    @Inject
    GankCustomAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_custome;
    }

    @Override
    protected void initInjector() {
        mFragmentComponent.inject(this);
    }

    @Override
    protected void initView(View view) {
        srlFcCustome.setOnRefreshListener(this);
        rvFcCustom.setLayoutManager(new LinearLayoutManager(getParentFragment().getContext()));
        mAdapter.setOnLoadMoreListener(this,rvFcCustom);
        rvFcCustom.setAdapter(mAdapter);
        mPresenter.loadCustomeData();
    }

    public static BaseFragment getInstance() {
        return new GankCustomFragment();
    }

    @Override
    public void showCustomeData(List<GankIoCustomItemBean> gankIoCustomListBean, int loadType) {
        setLoadDataResult(mAdapter,srlFcCustome,gankIoCustomListBean,loadType);
    }

    @Override
    public String getType() {
        return "Android";
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
