package com.az.kotlinsample.mvvm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.az.kotlinsample.mvvm.viewmodel.MainActivityViewModel
import com.az.kotlinsample.mvvm.viewmodel.UserViewModel
import com.az.kotlinsample.repository.UserRepository
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by zorin.a on 29.11.2017.
 */
class ViewModelFactory
@Inject constructor(private val router: Router, private val userRepository: UserRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(UserViewModel::class.java)) return UserViewModel(router, userRepository) as T

        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) return MainActivityViewModel(router) as T

        throw IllegalArgumentException("Unknow viewmodel class")
    }
}