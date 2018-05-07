package com.it.onex.onex.ui.fragment.gank.day;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.bean.TempGankDayBean;
import com.it.onex.onex.constant.LoadType;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by OnexZgj on 2018/5/3:17:15.
 * des:干货每日推荐Fragment
 */

public class GankDayFragment extends BaseFragment<GankDayPresenterImp> implements GankDayContract.View, BaseQuickAdapter.OnItemClickListener,  SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rv_fgid_day)
    RecyclerView rvFgidDay;
    @BindView(R.id.srl_fgid_day)
    SwipeRefreshLayout srlFgidDay;

    @Inject
    GankDayAdapter mAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank_io_day;
    }

    @Override
    protected void initInjector() {
        mFragmentComponent.inject(this);
    }

    @Override
    protected void initView(View view) {

        rvFgidDay.setLayoutManager(new LinearLayoutManager(getParentFragment().getContext()));
        mAdapter.setOnItemClickListener(this);
        srlFgidDay.setOnRefreshListener(this);

        rvFgidDay.setAdapter(mAdapter);

        mPresenter.loadGankDayData();
    }

    public static BaseFragment getInstance() {
        return new GankDayFragment();
    }



    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

        ARouter.getInstance().build("/article/ArticleContentActivity")
                .withInt("id",123)
                .withString("url",mAdapter.getItem(position).getUrl())
                .withString("title",mAdapter.getItem(position).getTitle())
                .withString("author",mAdapter.getItem(position).getWho())
                .navigation();

    }


    @Override
    public void onRefresh() {
        mPresenter.refresh();
    }

    @Override
    public void showDayData(List<TempGankDayBean> bean) {
        setLoadDataResult(mAdapter,srlFgidDay,bean, LoadType.TYPE_REFRESH_SUCCESS);
    }
}
