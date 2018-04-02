package com.it.onex.onex.di.component;

import android.app.Activity;
import android.content.Context;
import com.it.onex.onex.di.module.FragmentModule;
import com.it.onex.onex.di.scope.ContextLife;
import com.it.onex.onex.di.scope.PerFragment;

import dagger.Component;

/**
 * Created by lw on 2017/1/19.
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

//    void inject(HomeFragment fragment);

}
