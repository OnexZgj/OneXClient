package com.it.onex.onex.ui.fragment.hot;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.it.onex.onex.R;
import com.it.onex.onex.bean.Friend;

import javax.inject.Inject;

/**
 * Created by OnexZgj on 2018/1/23.
 */

public class CommonHotAdapter extends BaseQuickAdapter<Friend, BaseViewHolder> {

    @Inject
    public CommonHotAdapter() {
        super(R.layout.item_hot, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, Friend item) {
        helper.setText(R.id.tvTitle, item.getName());
    }
}
