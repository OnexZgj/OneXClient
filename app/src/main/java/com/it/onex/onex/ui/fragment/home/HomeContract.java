package com.it.onex.onex.ui.fragment.home;


import com.it.onex.onex.base.BaseContract;
import com.it.onex.onex.bean.Article;
import com.it.onex.onex.bean.BannerData;
import com.it.onex.onex.constant.LoadType;

import java.util.List;

/**
 * Created by lw on 2018/1/18.
 */

public interface HomeContract {

    interface View extends BaseContract.BaseView {
        void setHomeBanners(List<BannerData> banners);

        void setHomeArticles(Article article, @LoadType.checker int loadType);

        void collectArticleSuccess(int position, Article.DatasBean bean);

    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void loadHomeBanners();

        void loadHomeArticles();

        void refresh();

        void loadMore();

        void collectArticle(int position, Article.DatasBean bean);

        /**
         * 一次性请求多次网络
         */
        void loadHomeData();
    }
}
