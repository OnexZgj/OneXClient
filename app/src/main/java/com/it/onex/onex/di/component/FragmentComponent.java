package com.it.onex.onex.di.component;

import android.app.Activity;
import android.content.Context;

import com.it.onex.onex.di.module.FragmentModule;
import com.it.onex.onex.di.scope.ContextLife;
import com.it.onex.onex.di.scope.PerFragment;
import com.it.onex.onex.ui.fragment.article.ArticleListFragment;
import com.it.onex.onex.ui.fragment.gank.welfare.GankWelFareFragment;
import com.it.onex.onex.ui.fragment.home.HomeFragment;
import com.it.onex.onex.ui.fragment.hot.HotFragment;
import com.it.onex.onex.ui.fragment.knowledge.KnowLedgeFragment;
import com.it.onex.onex.ui.fragment.me.MeFragment;
import com.it.onex.onex.ui.fragment.navigation.NavigationFragment;
import com.it.onex.onex.ui.fragment.project.ProjectDetailFragment;
import com.it.onex.onex.ui.fragment.project.ProjectFragment;

import dagger.Component;

/**
 * Created by OnexZgj on 2018/5/4.
 * 使用的是Dagger2的方法和参数
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(HomeFragment fragment);

    void inject(MeFragment fragment);

    void inject(KnowLedgeFragment fragment);

    void inject(ArticleListFragment fragment);

    void inject(NavigationFragment fragment);

    void inject(ProjectFragment fragment);

    void inject(ProjectDetailFragment fragment);

    void inject(HotFragment fragment);

    void inject(GankWelFareFragment fragment);

}
