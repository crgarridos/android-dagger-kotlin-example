package com.cristiangarrido.daggerandroid.di

import android.app.Activity
import android.content.Context
import com.cristiangarrido.daggerandroid.MainActivity
import com.cristiangarrido.daggerandroid.base.ProjectApp
import dagger.*
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.multibindings.IntoMap
import javax.inject.Singleton


/**
 * Created by cristian on 21/11/17.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ContextModule::class,
    ActivityBindingModule::class])
interface AppComponent : AndroidInjector<ProjectApp> {

    override fun inject(app: ProjectApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: ProjectApp): Builder

        fun build(): AppComponent
    }

}

@Module
class ContextModule {
    //@Binds abstract fun provideContext(context: Context): Context
    @Provides
    fun provideContext(context: Context): Context = context
}

@Module(subcomponents = [MainActivityComponent::class])
abstract class ActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindMainActivity(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}

@Module
class MainActivityModule {
    @Provides
    fun provideHelloWorld() = "Hola mundo!"

}