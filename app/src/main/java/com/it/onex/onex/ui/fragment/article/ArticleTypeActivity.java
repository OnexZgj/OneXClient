package com.it.onex.onex.ui.fragment.article;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseActivity;
import com.it.onex.onex.bean.KnowledgeSystem;

import java.util.List;

import butterknife.BindView;

@Route(path = "/article/ArticleTypeActivity")
public class ArticleTypeActivity extends BaseActivity {

    @Autowired
    public String title;
    @Autowired
    public List<KnowledgeSystem.ChildrenBean> childrenData;
    @BindView(R.id.tabArticleTypes)
    TabLayout tabArticleTypes;
    @BindView(R.id.vp_aat_content)
    ViewPager vpAatContent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_article_type;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        setToolbarTitle(title);
        vpAatContent.setAdapter(new ArticleTypePageAdapter(getSupportFragmentManager(),childrenData));
    }

}
