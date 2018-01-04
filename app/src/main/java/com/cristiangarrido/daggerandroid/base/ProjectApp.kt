package com.cristiangarrido.daggerandroid.base

import android.app.Application
import com.cristiangarrido.daggerandroid.di.AppComponent
import com.cristiangarrido.daggerandroid.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


/**
 * Created by cristian on 21/11/17.
 */
class ProjectApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<ProjectApp> {
        return component
    }

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                //.application(this)
                .build()
    }


    override fun onCreate() {
        super.onCreate()
        component
    }

}