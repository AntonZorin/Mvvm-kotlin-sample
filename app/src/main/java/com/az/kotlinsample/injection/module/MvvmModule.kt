package com.az.kotlinsample.injection.module

import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.az.kotlinsample.db.dao.UserDao
import com.az.kotlinsample.db.database.UsersDatabase
import com.az.kotlinsample.mvvm.ViewModelFactory
import com.az.kotlinsample.repository.UserRepository
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

/**
 * Created by zorin.a on 07.12.2017.
 */
@Module
class MvvmModule {

    @Provides
    fun provideUserDatasource(context: Context): UserDao = UsersDatabase.getInstance(context).userDao()

    @Provides
    fun provideViewModelFactory(router: Router, userRepository: UserRepository): ViewModelFactory =
            ViewModelFactory( router,userRepository)

    @Provides
    fun provideFragmentManager(context: Context): FragmentManager {
        val activity = context as AppCompatActivity
        return activity.supportFragmentManager
    }
}