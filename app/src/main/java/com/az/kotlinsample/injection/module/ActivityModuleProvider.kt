package com.az.kotlinsample.injection.module

import android.app.Activity
import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.az.kotlinsample.injection.qualifier.ActivityQualifier
import com.az.kotlinsample.injection.scope.PerActivity
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by zorin.a on 06.12.2017.
 */
@Module
class ActivityModuleProvider {

    @Provides
    @PerActivity
    fun provideFragmentManager(activity: AppCompatActivity): FragmentManager = activity.supportFragmentManager

    @Provides
//    @ActivityQualifier
    @Named("act")
    fun provideContext(activity: Activity): Context = activity
}