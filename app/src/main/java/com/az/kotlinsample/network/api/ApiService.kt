package com.az.kotlinsample.network.api

import com.az.kotlinsample.network.request.LoginRequest
import com.az.kotlinsample.network.response.CarsResponse
import com.az.kotlinsample.network.response.LoginResponse
import com.az.kotlinsample.network.response.ProfileResponse
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by zorin.a on 08.12.2017.
 */
interface ApiService {
    @POST("/user/login")
    fun login(@Body request: LoginRequest): Observable<LoginResponse>

    @GET("/user/profile")
    fun getUser(@Query("image_density") imageDensity: Int): Observable<ProfileResponse>

    @GET("/user/cars")
    fun getCars(@Query("image_density") imageDensity: Int,
                         @Query("limit") limit: Int,
                         @Query("offset") offset: Int): Observable<CarsResponse>
}