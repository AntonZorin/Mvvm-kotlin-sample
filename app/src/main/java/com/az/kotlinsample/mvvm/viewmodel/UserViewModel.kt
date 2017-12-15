package com.az.kotlinsample.mvvm.viewmodel

import com.az.kotlinsample.network.request.LoginRequest
import com.az.kotlinsample.network.response.CarsResponse
import com.az.kotlinsample.network.response.ProfileResponse
import com.az.kotlinsample.repository.UserRepository
import io.reactivex.Observable
import ru.terrakok.cicerone.Router

/**
 * Created by zorin.a on 29.11.2017.
 */

class UserViewModel(router: Router, private val userRepository: UserRepository) : BaseViewModel(router) {

    fun login(): Observable<Boolean> = userRepository.login(LoginRequest("Ivanov", "3as24sd2"))

    fun getUser(): Observable<ProfileResponse> = userRepository.getUser(1)

    fun getUserCars(limit: Int, offset: Int): Observable<CarsResponse> = userRepository.getCars(1, limit, offset)
}