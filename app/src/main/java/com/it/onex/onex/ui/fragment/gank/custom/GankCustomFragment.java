package com.it.onex.onex.ui.fragment.gank.custom;

import android.content.DialogInterface;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cocosw.bottomsheet.BottomSheet;
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

public class GankCustomFragment extends BaseFragment<GankCustomPresenterImp> implements GankCustomContract.View, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemClickListener, View.OnClickListener {
    @BindView(R.id.rv_fc_custom)
    RecyclerView rvFcCustom;
    @BindView(R.id.srl_fc_custome)
    SwipeRefreshLayout srlFcCustome;

    @Inject
    GankCustomAdapter mAdapter;

    private View headView;
    /**
     * 种类的type变量
     */
    private String mCustomType = "all";


    /**
     * HeadView中展示的分类的title
     */
    private TextView tvHeadName;

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
        if (headView == null) {
            headView = View.inflate(getContext(), R.layout.sub_gank_io_custom_head, null);
            tvHeadName = headView.findViewById(R.id.tv_type_name);
            headView.setOnClickListener(this);
        }
        srlFcCustome.setOnRefreshListener(this);
        rvFcCustom.setLayoutManager(new LinearLayoutManager(getParentFragment().getContext()));
        mAdapter.setOnLoadMoreListener(this, rvFcCustom);
        mAdapter.setOnItemClickListener(this);
        rvFcCustom.setAdapter(mAdapter);
        //为了防止重复加载
        mAdapter.addHeaderView(headView);
//        mAdapter.setHeaderView(headView);
        mPresenter.loadCustomeData();
    }

    public static BaseFragment getInstance() {
        return new GankCustomFragment();
    }

    @Override
    public void showCustomeData(List<GankIoCustomItemBean> gankIoCustomListBean, int loadType) {
        setLoadDataResult(mAdapter, srlFcCustome, gankIoCustomListBean, loadType);
    }

    @Override
    public String getType() {
        return mCustomType;
    }

    /**
     * 展示选择的分类
     */
    private void showBottomSheet() {
        new BottomSheet.Builder(getActivity(), R.style.BottomSheet_StyleDialog)
                .title("选择分类:")
                .sheet(R.menu.gank_io_custom_bottom_sheet)
                .listener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case R.id.item_gank_all:
                                mCustomType = "all";
                                tvHeadName.setText("全部");
                                break;
                            case R.id.item_gank_app:
                                mCustomType = "App";
                                tvHeadName.setText("App");
                                break;
                            case R.id.item_gank_android:
                                mCustomType = "Android";
                                tvHeadName.setText("Android");
                                break;
                            case R.id.item_gank_ios:
                                mCustomType = "iOS";
                                tvHeadName.setText("iOS");
                                break;
                            case R.id.item_gank_front:
                                mCustomType = "前端";
                                tvHeadName.setText("前端");
                                break;
                            case R.id.item_gank_video:
                                mCustomType = "休息视频";
                                tvHeadName.setText("休息视频");
                                break;
                            case R.id.item_gank_tuozhan:
                                mCustomType = "拓展资源";
                                tvHeadName.setText("拓展资源");
                                break;
                        }

                        mPresenter.loadCustomeData();

                    }
                }).show();
    }

    @Override
    public void onRefresh() {
        mPresenter.refresh();
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.loadMore();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

        ARouter.getInstance().build("/article/ArticleContentActivity")
                .withInt("id", 123)
                .withString("url", mAdapter.getItem(position).getUrl())
                .withString("title", getType())
                .withString("author", mAdapter.getItem(position).getWho())
                .navigation();

    }

    @Override
    public void onClick(View v) {
        showBottomSheet();
    }
}
