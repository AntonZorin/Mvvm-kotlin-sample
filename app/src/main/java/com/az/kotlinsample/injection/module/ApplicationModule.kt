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
     * convention. In general, providing Activity, Fragment, BroadcastReceiver, etc does not require
     * them to be scoped since they are the components being injected and their instance is unique.
     *
     * However, having a scope annotation makes the module easier to read. We wouldn't have to look
     * at what is being provided in order to understand its scope.
     */

    @Binds
    @Singleton
    internal abstract fun context(app: KotlinApplication): Context

    @PerActivity
    @ContributesAndroidInjector(modules = [(ActivityModule::class)])
    internal abstract fun mainActivityInjector(): MainActivity
}