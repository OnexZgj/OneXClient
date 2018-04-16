package com.it.onex.onex.di.component;

import android.app.Activity;
import android.content.Context;

import com.it.onex.onex.di.module.ActivityModule;
import com.it.onex.onex.di.scope.ContextLife;
import com.it.onex.onex.di.scope.PerActivity;
import com.it.onex.onex.ui.fragment.article.ArticleTypeActivity;

import dagger.Component;

/**
 * Created by OnexZgj on 2018/4/2.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(ArticleTypeActivity activity);

}
