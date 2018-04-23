package com.it.onex.onex.search;


import com.it.onex.onex.base.BaseContract;
import com.it.onex.onex.bean.Article;
import com.it.onex.onex.constant.LoadType;

/**
 * Created by lw on 2018/1/23.
 */

public interface SearchContract {
    interface View extends BaseContract.BaseView {
        void setSearchArtcles(Article article, @LoadType.checker int loadType);

        void collectArticleSuccess(int position, Article.DatasBean bean);

    }

    interface Presenter extends BaseContract.BasePresenter<SearchContract.View> {
        void loadSearchArtcles(String k);

        void refresh();

        void loadMore();

        void collectArticle(int position, Article.DatasBean bean);

        void loadHistory();

        void addHistory(String name);
    }
}
