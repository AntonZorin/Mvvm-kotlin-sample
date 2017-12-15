package com.az.kotlinsample.injection.module

import com.az.kotlinsample.injection.scope.PerFragment
import com.az.kotlinsample.ui.fragment.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by zorin.a on 05.12.2017.
 */

@Module(includes = [(ActivityModuleProvider::class)])
abstract class ActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [(FragmentModule::class)])
    internal abstract fun mainActivityInjector(): UserFragment

}