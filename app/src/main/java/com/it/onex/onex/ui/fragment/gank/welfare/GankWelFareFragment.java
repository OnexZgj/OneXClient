package com.it.onex.onex.ui.fragment.gank.welfare;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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

public class GankWelFareFragment extends BaseFragment<GankWelFarePresenterImp> implements GankWelFareContract.View, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnItemLongClickListener {
    @BindView(R.id.rv_gankio_welfare)
    RecyclerView rvGankioWelfare;
    @BindView(R.id.srl_fgiw_welfare)
    SwipeRefreshLayout srlFgiwWelfare;

    @Inject
    WelFareAdapter mAdapter;

    /**
     * 请求回来的数据
     */
    private GankIoWelfareListBean mData;


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

//        rvGankioWelfare.setLayoutManager(new LinearLayoutManager(getParentFragment().getContext()));

        rvGankioWelfare.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemLongClickListener(this);
        mAdapter.setOnLoadMoreListener(this, rvGankioWelfare);
        rvGankioWelfare.setAdapter(mAdapter);
        mPresenter.loadWelFareData();
    }


    @Override
    public void showWelFareData(GankIoWelfareListBean data, int loadType) {
        this.mData = data;
        setLoadDataResult(mAdapter, srlFgiwWelfare, data.getResults(), loadType);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//        ToastUtils.showShort("position : " + position);
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.loadMore();
    }

    @Override
    public void onRefresh() {
        mPresenter.refresh();
    }

    public static GankWelFareFragment getInstance() {
        return new GankWelFareFragment();
    }

    @Override
    public boolean onItemLongClick(BaseQuickAdapter adapter, View view, final int position) {



        mPresenter.saveImageToLocal(getContext(),mData.getResults().get(position).getUrl());






//        new AsyncTask<Void, Void, Void>() {
//            @Override
//            protected Void doInBackground(Void... voids) {
//                try {
//                    File file = Glide.with(getContext())
//                            .load(mData.getResults().get(position).getUrl())
//                            .downloadOnly(1080, 1920)
//                            .get();
//
//                    FileUtils.copyFile(file, new File(Environment.getExternalStorageDirectory() + "/onexpic/" + mData.getResults().get(position).getUrl()), new FileUtils.OnReplaceListener() {
//                        @Override
//                        public boolean onReplace() {
//                            return false;
//                        }
//                    });
//
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//                super.onPostExecute(aVoid);
//            }
//        }.execute();


        return false;
    }
}
