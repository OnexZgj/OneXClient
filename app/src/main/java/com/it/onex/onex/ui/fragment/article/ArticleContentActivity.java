package com.it.onex.onex.ui.fragment.article;

import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseActivity;
import com.just.agentweb.AgentWeb;

import butterknife.BindView;

/**
 * 展示文章内容的Activity
 * create by OnexZgj on 2018/04/03
 */
@Route(path = "/article/ArticleContentActivity")
public class ArticleContentActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.webContent)
    FrameLayout webContent;


    @Autowired
    public int id;
    @Autowired
    public String url;
    @Autowired
    public String title;
    @Autowired
    public String author;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_article_content;
    }

    @Override
    protected void initInjector() {

        ARouter.getInstance().inject(this);
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initView() {
        setToolbarTitle(title);
        AgentWeb mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(webContent, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator(Color.GREEN)
                .createAgentWeb()
                .ready()
                .go(url);
    }

    @Override
    protected boolean showHomeAsUp() {
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_content, menu);
        return true;
    }

}
