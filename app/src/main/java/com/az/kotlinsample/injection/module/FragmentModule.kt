package com.az.kotlinsample.injection.module

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.az.kotlinsample.injection.qualifier.FragmentQualifier
import com.az.kotlinsample.injection.scope.PerFragment
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by zorin.a on 05.12.2017.
 */

@Module
abstract class FragmentModule {
//    @Provides
//    @Singleton
//    @FragmentQualifier
//    @PerFragment
//    fun provideFragmentManager(fragment: Fragment): FragmentManager = fragment.childFragmentManager
}