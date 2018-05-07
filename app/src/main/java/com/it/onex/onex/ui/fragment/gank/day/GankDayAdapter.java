package com.it.onex.onex.ui.fragment.gank.day;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.it.onex.onex.R;
import com.it.onex.onex.bean.TempGankDayBean;

import javax.inject.Inject;

/**
 * Created by Linsa on 2018/5/7:14:36.
 * des:
 */

public class GankDayAdapter extends BaseQuickAdapter<TempGankDayBean,BaseViewHolder> {

    @Inject
    public GankDayAdapter() {
        super(R.layout.item_gank_day, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, TempGankDayBean item) {
        helper.setText(R.id.tv_igd_title,item.getTitle());
        helper.setText(R.id.tv_igd_author,item.getWho());
        helper.setText(R.id.tv_igd_desc,item.getDesc());

        if (item.getImages()!=null && item.getImages().get(0)!=null) {
            Glide.with(mContext).load(item.getImages().get(0))

                    .into((ImageView) helper.getView(R.id.iv_igd_icon));
        }else{
            Glide.with(mContext).load(R.mipmap.img_default_meizi)

                    .into((ImageView) helper.getView(R.id.iv_igd_icon));
        }
    }
}
