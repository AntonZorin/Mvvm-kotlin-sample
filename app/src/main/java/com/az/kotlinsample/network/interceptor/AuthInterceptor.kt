package com.az.kotlinsample.network.interceptor

import com.az.kotlinsample.common.PrefManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Created by zorin.a on 08.12.2017.
 */
class AuthInterceptor @Inject constructor(private val prefManager: PrefManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
                .addHeader("Authorization", prefManager.getToken())
                .build()
        return chain.proceed(newRequest) ?: chain.proceed(request)
    }
}