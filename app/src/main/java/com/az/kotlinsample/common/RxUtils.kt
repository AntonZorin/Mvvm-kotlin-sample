package com.az.kotlinsample.common

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by zorin.a on 15.12.2017.
 */
class RxUtils {
    companion object {
        fun <T : Any> applySchedulers(): ObservableTransformer<T, T> =
                ObservableTransformer { upstream ->
                    upstream.observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                }
    }
}