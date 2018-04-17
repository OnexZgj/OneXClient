package com.it.onex.onex.ui.fragment.project;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.it.onex.onex.R;
import com.it.onex.onex.bean.ProjectDetail;

import javax.inject.Inject;

/**
 * Created by OneXzgj on 2018/4/3:10:48.
 * des:
 */

public class ProjectDetailAdapter extends BaseQuickAdapter<ProjectDetail.DatasBean,BaseViewHolder> {

    @Inject
    public ProjectDetailAdapter() {
        super(R.layout.item_project, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProjectDetail.DatasBean item) {
        helper.setText(R.id.tv_ip_title,item.getTitle());
        helper.setText(R.id.tv_ip_des, item.getDesc());
        Glide.with(mContext).load(item.getEnvelopePic()).into((ImageView) helper.getView(R.id.iv_ip_icon));
    }
}
