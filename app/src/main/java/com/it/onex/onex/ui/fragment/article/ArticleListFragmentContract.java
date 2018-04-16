package com.it.onex.onex.ui.fragment.article;

import com.it.onex.onex.base.BaseContract;
import com.it.onex.onex.bean.ArticleTypeContent;

/**
 * Created by Linsa on 2018/4/16:11:35.
 * des:
 */

public class ArticleListFragmentContract {
    interface View extends BaseContract.BaseView{
        void setArticleList(ArticleTypeContent articleContent,int loadType);
    }

    interface Presenter extends BaseContract.BasePresenter<ArticleListFragmentContract.View>{
        void loadArticleListData(int cid);

        void refresh();

        void loadMore();
    }
}
