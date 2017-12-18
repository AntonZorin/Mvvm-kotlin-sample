package com.az.kotlinsample.mvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ru.terrakok.cicerone.Router

/**
 * Created by zorin.a on 29.11.2017.
 */
abstract class BaseViewModel(private val router: Router) : ViewModel() {
    internal var progressData = MutableLiveData<Boolean>()
    internal var errorData = MutableLiveData<Boolean>()
    fun switchScreen(screen: String, data: Any? = null) = if (data != null) {
        router.navigateTo(screen)
    } else {
        router.navigateTo(screen, data)
    }
}
