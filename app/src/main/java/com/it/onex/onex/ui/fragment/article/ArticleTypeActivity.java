package com.it.onex.onex.ui.fragment.article;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ToastUtils;
import com.it.onex.onex.R;
import com.it.onex.onex.bean.KnowledgeSystem;

import java.util.List;

@Route(path = "/article/ArticleTypeActivity")
public class ArticleTypeActivity extends AppCompatActivity {

    @Autowired
    public String title;
    @Autowired
    public List<KnowledgeSystem.ChildrenBean> childrenData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_type);
        ARouter.getInstance().inject(this);
        ToastUtils.showShort(title);
    }
}
