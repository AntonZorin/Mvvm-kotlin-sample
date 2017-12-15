package com.az.kotlinsample.repository

import com.az.kotlinsample.common.PrefManager
import com.az.kotlinsample.db.dao.UserDao
import com.az.kotlinsample.network.api.ApiManager
import com.az.kotlinsample.network.request.LoginRequest
import com.az.kotlinsample.network.response.CarsResponse
import com.az.kotlinsample.network.response.LoginResponse
import com.az.kotlinsample.network.response.ProfileResponse
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by zorin.a on 15.12.2017.
 */
//TODO: implement db
class UserRepository @Inject constructor(private val dataSource: UserDao, val apiManager: ApiManager, val prefManager: PrefManager) {

    fun login(request: LoginRequest): Observable<Boolean> = apiManager
            .login(request)
            .doOnNext { response ->
                saveToken(response)
            }
            .map({ resp -> resp.isSuccess })

    fun getUser(imageDensity: Int): Observable<ProfileResponse> = apiManager.getUser(imageDensity)

    fun getCars(imageDensity: Int, limit: Int, offset: Int): Observable<CarsResponse> = apiManager.getCars(imageDensity, limit, offset)


    private fun saveToken(response: LoginResponse): Observable<LoginResponse> {
        val token = response.token
        prefManager.seveToken(token)
        return Observable.just(response)
    }

//    fun saveUser(user: User): CompletableFromAction = CompletableFromAction(Action { dataSource.insertUser(user) })
//
//    fun queryUserByName(name: String): Flowable<User> = dataSource.getUserByName(name)
}