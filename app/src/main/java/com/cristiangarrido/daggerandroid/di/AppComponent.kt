package com.cristiangarrido.daggerandroid.di

import com.cristiangarrido.daggerandroid.base.ProjectApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * Created by cristian on 21/11/17.
 */
@Singleton
@Component(modules = arrayOf(
        /* Use AndroidInjectionModule.class if you're not using support library */
        AndroidSupportInjectionModule::class/*,
    AppModule.class,
    BuildersModule.class*/
))/* Use AndroidInjectionModule.class if you're not using support library */
interface AppComponent : AndroidInjector<ProjectApp> {

    override fun inject(app: ProjectApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: ProjectApp): Builder

        fun build(): AppComponent
    }

}