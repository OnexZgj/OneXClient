package com.it.onex.onex.ui.fragment.knowledge;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.it.onex.onex.R;
import com.it.onex.onex.bean.KnowledgeSystem;

import javax.inject.Inject;

/**
 * Created by zhanggj on 2018/4/12:23:04.
 * des:
 */

public class KnowledgeSystemAdapter extends BaseQuickAdapter<KnowledgeSystem ,BaseViewHolder> {

    @Inject
    public KnowledgeSystemAdapter() {
        super(R.layout.item_knowledge, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, KnowledgeSystem item) {
        helper.setText(R.id.typeItemFirst, item.getName());
        StringBuffer sb = new StringBuffer();
        for (KnowledgeSystem.ChildrenBean childrenBean : item.getChildren()) {
            sb.append(childrenBean.getName() + "     ");
        }
        helper.setText(R.id.typeItemSecond, sb.toString());
    }
}
