package com.az.kotlinsample.injection.module

import android.content.Context
import com.az.kotlinsample.injection.scope.PerActivity
import com.az.kotlinsample.ui.activity.MainActivity
import com.az.kotlinsample.ui.app.KotlinApplication
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by zorin.a on 05.12.2017.
 */

@Module(includes = [(AndroidSupportInjectionModule::class), (MvvmModule::class), (ApiModuleProvider::class)])
abstract class ApplicationModule {
    /*
     * Singleton annotation isn't necessary since Application instance is unique but is here for
     * convention.
     */

    @Binds
    @Singleton
    internal abstract fun context(app: KotlinApplication): Context

    @PerActivity
    @ContributesAndroidInjector(modules = [(ActivityModule::class)])
    internal abstract fun mainActivityInjector(): MainActivity
}