package com.it.onex.onex.di.component;

import android.content.Context;

import com.it.onex.onex.di.module.ApplicationModule;
import com.it.onex.onex.di.scope.ContextLife;
import com.it.onex.onex.di.scope.PerApp;

import dagger.Component;


/**
 * Created by OnexZgj on 2017/1/19.
 */
@PerApp
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ContextLife("Application")
    Context getApplication();
}