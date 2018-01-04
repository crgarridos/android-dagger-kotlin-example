package com.cristiangarrido.daggerandroid.base

import com.cristiangarrido.daggerandroid.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


/**
 * Created by cristian on 21/11/17.
 */
class ProjectApp: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<ProjectApp> {
        return DaggerAppComponent.builder().application(this).build()
    }
}