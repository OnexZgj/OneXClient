package com.it.onex.onex.ui.fragment.hot;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.bean.Friend;
import com.it.onex.onex.bean.HotKey;
import com.it.onex.onex.constant.Constant;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by OnexZgj on 2018/4/18:16:47.
 * des:
 */

public class HotFragment extends BaseFragment<HotFragmentImp> implements HotContract.View, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.rv_fh_hotkey)
    RecyclerView rvFhHotkey;
    @BindView(R.id.srl_fh_refresh)
    SwipeRefreshLayout srlFhRefresh;
    private View mHotHeadView;
    private TagFlowLayout mTflHotKeys;
    private TagFlowLayout mTflHotFriends;

    private HotAdapter<HotKey> mHotKeyAdapter;
    private HotAdapter<Friend> mHotFriendAdapter;

    @Inject
    CommonHotAdapter mCommonHotAdapter;

    public static HotFragment getInstance() {
        return new HotFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initInjector() {
        mFragmentComponent.inject(this);
    }

    @Override
    protected void initView(View view) {
        rvFhHotkey.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFhHotkey.setAdapter(mCommonHotAdapter);

        /**设置HotHeadView*/
        mHotHeadView = LayoutInflater.from(getContext()).inflate(R.layout.layout_hot_head, null);
        mTflHotKeys = (TagFlowLayout) mHotHeadView.findViewById(R.id.tflHotKeys);
        mTflHotFriends = (TagFlowLayout) mHotHeadView.findViewById(R.id.tflHotFriends);
        mCommonHotAdapter.addHeaderView(mHotHeadView);

        /**设置监听*/
        setListener();

        /**请求数据*/
        mPresenter.loadHotData();

    }

    @Override
    public void setHotData(List<HotKey> hotKeys, List<Friend> friends) {
        mHotKeyAdapter = new HotAdapter(getContext(), hotKeys);
        mTflHotKeys.setAdapter(mHotKeyAdapter);

        mHotFriendAdapter = new HotAdapter<>(getContext(), friends);
        mTflHotFriends.setAdapter(mHotFriendAdapter);

        srlFhRefresh.setRefreshing(false);
    }

    private void setListener() {
        srlFhRefresh.setOnRefreshListener(this);
        mTflHotKeys.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                String name = mHotKeyAdapter.getItem(position).getName();
                ARouter.getInstance().build("/hotsearch/SearchActivity")
                        .withString(Constant.CONTENT_HOT_NAME_KEY, name)
                        .navigation();
                return false;
            }
        });
        mTflHotFriends.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {

                ARouter.getInstance().build("/article/ArticleContentActivity")
                        .withInt("id",mHotFriendAdapter.getItem(position).getId())
                        .withString("url",mHotFriendAdapter.getItem(position).getLink())
                        .withString("title",mHotFriendAdapter.getItem(position).getName())
                        .withString("author","")
                        .navigation();
                return false;
            }
        });
    }

    @Override
    public void onRefresh() {
        mPresenter.refresh();
    }
}
