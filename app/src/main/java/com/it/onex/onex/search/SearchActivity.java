package com.it.onex.onex.search;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseActivity;

import butterknife.BindView;

/**
 * 搜索关键界面的Activity
 *
 * @author OnexZgj
 * @time 2018/04/19
 */

@Route(path = "/hotsearch/SearchActivity")
public class SearchActivity extends BaseActivity {


    @BindView(R.id.rv_as_list)
    RecyclerView rvAsList;
    @BindView(R.id.swl_as_refresh)
    SwipeRefreshLayout swlAsRefresh;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
