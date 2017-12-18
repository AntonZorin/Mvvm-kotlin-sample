package com.az.kotlinsample.mvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ru.terrakok.cicerone.Router

/**
 * Created by zorin.a on 29.11.2017.
 */
abstract class BaseViewModel(private val router: Router) : ViewModel() {
    //region var
    private var disposableList = CompositeDisposable()
    internal var progressData = MutableLiveData<Boolean>()
    internal var errorData = MutableLiveData<Boolean>()
    //endregion

    override fun onCleared() {
        super.onCleared()
        clearDisposable()
    }

    fun switchScreen(screen: String, data: Any? = null) = if (data != null) {
        router.navigateTo(screen)
    } else {
        router.navigateTo(screen, data)
    }

    protected fun clearDisposable() = disposableList.clear()

    protected fun addDisposable(disposable: Disposable) = disposableList.add(disposable)

}
