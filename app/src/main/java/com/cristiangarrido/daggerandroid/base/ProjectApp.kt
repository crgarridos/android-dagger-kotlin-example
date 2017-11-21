package com.cristiangarrido.daggerandroid.base

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


/**
 * Created by cristian on 21/11/17.
 */
class ProjectApp: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}