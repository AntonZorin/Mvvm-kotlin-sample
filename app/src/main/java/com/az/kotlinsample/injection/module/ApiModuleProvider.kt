package com.az.kotlinsample.injection.module

import android.content.Context
import com.az.kotlinsample.common.Constants
import com.az.kotlinsample.common.PrefManager
import com.az.kotlinsample.network.interceptor.AuthInterceptor
import com.az.kotlinsample.network.api.ApiManager
import com.az.kotlinsample.network.api.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton

/**
 * Created by zorin.a on 08.12.2017.
 */


@Module
class ApiModuleProvider {
    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .baseUrl(Constants.API_URL)
                    .build()

    @Provides
    @Singleton
    fun provideApiManager(apiService: ApiService): ApiManager =
            ApiManager(apiService)

    @Provides
    @Singleton
    internal fun providesApiService(retrofit: Retrofit): ApiService =
            retrofit.create(ApiService::class.java)


    @Provides
    @Singleton
    fun provideOkHttp(context: Context, prefManager: PrefManager): OkHttpClient {
        val cacheDir = File(context.cacheDir, "http_cache")
        val cache = Cache(cacheDir, Constants.DISK_CACHE_SIZE)
        return OkHttpClient
                .Builder()
                .addInterceptor(AuthInterceptor(prefManager))
                .cache(cache)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson = GsonBuilder().create()
}