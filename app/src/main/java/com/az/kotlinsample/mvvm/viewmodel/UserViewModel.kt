package com.az.kotlinsample.mvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.az.kotlinsample.mvvm.models.Car
import com.az.kotlinsample.mvvm.models.User
import com.az.kotlinsample.network.request.LoginRequest
import com.az.kotlinsample.repository.UserRepository
import ru.terrakok.cicerone.Router

/**
 * Created by zorin.a on 29.11.2017.
 */

class UserViewModel(router: Router, private val userRepository: UserRepository) : BaseViewModel(router) {
    internal var loginData = MutableLiveData<Boolean>()
    internal var userData = MutableLiveData<User>()
    internal var carsData = MutableLiveData<List<Car>>()

    fun login() {
        progressData.postValue(true)
        userRepository.login(LoginRequest("Ivanov", "3as24sd2"))
                .subscribe(
                        { success ->
                            if (success == true) {
                                loginData.postValue(true)
                            } else {
                                loginData.postValue(false)
                            }
                        }, { errorData.postValue(true) })
    }

    fun getUser() {
        progressData.postValue(true)
        userRepository.getUser(1)
                .subscribe({ resp ->
                    userData.postValue(resp.user)
                    progressData.postValue(false)
                }, { errorData.postValue(true) })
    }

    fun getUserCars(limit: Int, offset: Int) {
        progressData.postValue(true)
        userRepository.getCars(1, limit, offset)
                .subscribe({ resp ->
                    carsData.postValue(resp.cars)
                    progressData.postValue(false)
                })
    }
}