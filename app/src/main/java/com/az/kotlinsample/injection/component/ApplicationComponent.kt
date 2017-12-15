package com.az.kotlinsample.injection.component

import com.az.kotlinsample.injection.module.ApplicationModule
import com.az.kotlinsample.injection.module.CiceroneModule
import com.az.kotlinsample.ui.app.KotlinApplication
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton


/**
 * Created by zorin.a on 05.12.2017.
 */
@Singleton
@Component(modules = [(CiceroneModule::class), (ApplicationModule::class)])
interface ApplicationComponent : AndroidInjector<KotlinApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<KotlinApplication>()
}