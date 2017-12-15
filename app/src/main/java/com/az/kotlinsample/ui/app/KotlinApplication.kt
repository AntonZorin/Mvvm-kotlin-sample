package com.az.kotlinsample.ui.app

import android.app.Activity
import android.app.Application
import com.az.kotlinsample.injection.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by zorin.a on 05.12.2017.
 */

class KotlinApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>


    override fun activityInjector(): AndroidInjector<Activity> = activityInjector


    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder().create(this).inject(this)
    }

}