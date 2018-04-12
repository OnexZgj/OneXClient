package com.it.onex.onex.ui.fragment.knowledge;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.bean.KnowledgeSystem;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by OnexZgj on 2018/4/2:22:08.
 * des:知识体系Fragment
 */

public class KnowLedgeFragment extends BaseFragment<KnowledgeSystemPresenterImp> implements KnowledgeSystemContract.View, BaseQuickAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rv_fk_list)
    RecyclerView rvFkList;
    @BindView(R.id.srl_fk_refresh)
    SwipeRefreshLayout srlFkRefresh;

    @Inject
    KnowledgeSystemAdapter mKnowledgeSystemAdapter;

    public static KnowLedgeFragment getInstance() {
        return new KnowLedgeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_knowledge;
    }

    @Override
    protected void initInjector() {
        mFragmentComponent.inject(this);
    }



    @Override
    protected void initView(View view) {
        rvFkList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFkList.setAdapter(mKnowledgeSystemAdapter);

        /**设置事件监听*/
        mKnowledgeSystemAdapter.setOnItemClickListener(this);
        srlFkRefresh.setOnRefreshListener(this);

        /**请求数据*/
        mPresenter.loadKnowledgeSystems();
    }

    @Override
    public void setKnowledgeSystems(List<KnowledgeSystem> knowledgeSystems) {
        mKnowledgeSystemAdapter.setNewData(knowledgeSystems);
        srlFkRefresh.setRefreshing(false);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onRefresh() {
        mPresenter.refresh();
    }



    @Override
    public void showLoading() {
        srlFkRefresh.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        srlFkRefresh.setRefreshing(false);
    }

    @Override
    public void showFaild(String errorMsg) {
        srlFkRefresh.setRefreshing(false);
    }
}
