package com.cristiangarrido.daggerandroid.di

import android.app.Activity
import android.content.Context
import com.cristiangarrido.daggerandroid.MainActivity
import com.cristiangarrido.daggerandroid.base.ProjectApp
import dagger.*
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.multibindings.IntoMap
import javax.inject.Qualifier
import javax.inject.Scope
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
}

@Module
class ContextModule {
    //@Binds abstract fun provideContext(context: Context): Context
    @Provides
    fun provideContext(context: Context): Context = context
}

@Scope annotation class ActivityScope

@Singleton
@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [GreetingsModule::class])
    abstract fun contributeMainActivityInjector(): MainActivity
}

@Qualifier annotation class Spanish
@Qualifier annotation class French
@Qualifier annotation class English

@Module
@Singleton
class GreetingsModule {

    @Provides
    @Spanish
    fun providesHola(): String = "Hola mundo! - From Dagger"

    @Provides
    @English
    fun providesHello(): String = "Hello world! - From Dagger"

    @French
    @Provides
    fun provideBonjour(): String = "Bounjour tout le monde ! - From Dagger"

}

