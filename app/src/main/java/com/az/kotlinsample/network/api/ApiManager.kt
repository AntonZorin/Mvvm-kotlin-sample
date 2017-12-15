package com.az.kotlinsample.network.api

import com.az.kotlinsample.common.RxUtils.Companion.applySchedulers
import com.az.kotlinsample.network.request.LoginRequest
import com.az.kotlinsample.network.response.CarsResponse
import com.az.kotlinsample.network.response.LoginResponse
import com.az.kotlinsample.network.response.ProfileResponse
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by zorin.a on 08.12.2017.
 */

class ApiManager @Inject constructor(private val apiService: ApiService) {

    fun login(request: LoginRequest): Observable<LoginResponse> = apiService.login(request).compose(applySchedulers())

    fun getUser(imageDensity: Int): Observable<ProfileResponse> = apiService.getUser(imageDensity).compose(applySchedulers())

    fun getCars(imageDensity: Int, limit: Int, offset: Int): Observable<CarsResponse> =
            apiService.getCars(imageDensity, limit, offset).compose(applySchedulers())



}