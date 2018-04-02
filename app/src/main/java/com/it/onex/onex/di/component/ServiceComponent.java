package com.it.onex.onex.di.component;

import android.content.Context;

import com.it.onex.onex.di.module.ServiceModule;
import com.it.onex.onex.di.scope.ContextLife;
import com.it.onex.onex.di.scope.PerService;

import dagger.Component;


/**
 * Created by lw on 2017/1/19.
 */
@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {
    @ContextLife("Service")
    Context getServiceContext();

    @ContextLife("Application")
    Context getApplicationContext();
}
