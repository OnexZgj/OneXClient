package com.it.onex.onex.ui.fragment.article;

import android.text.Html;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.it.onex.onex.R;
import com.it.onex.onex.bean.Article;

import javax.inject.Inject;

/**
 * Created by OneXzgj on 2018/4/3:10:48.
 * des:
 */

public class ArticleAdapter extends BaseQuickAdapter<Article.DatasBean,BaseViewHolder> {

    @Inject
    public ArticleAdapter() {
        super(R.layout.item_article, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, Article.DatasBean item) {
        helper.setText(R.id.tvAuthor,item.getAuthor());
        helper.setText(R.id.tvNiceDate, item.getNiceDate());
        helper.setText(R.id.tvTitle, Html.fromHtml(item.getTitle()));
        helper.setText(R.id.tvChapterName, item.getChapterName());
        helper.setText(R.id.tvDesc, item.getDesc());

        helper.setImageResource(R.id.ivCollect, item.isCollect()
                ? R.drawable.ic_action_like : R.drawable.ic_action_no_like);
        helper.addOnClickListener(R.id.tvChapterName);
        helper.addOnClickListener(R.id.ivCollect);


    }
}
