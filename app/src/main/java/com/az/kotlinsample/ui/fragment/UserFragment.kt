package com.az.kotlinsample.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.view.View
import com.az.kotlinsample.R
import com.az.kotlinsample.mvvm.ViewModelFactory
import com.az.kotlinsample.mvvm.models.Car
import com.az.kotlinsample.mvvm.models.User
import com.az.kotlinsample.mvvm.viewmodel.UserViewModel
import com.az.kotlinsample.network.response.ProfileResponse
import com.az.kotlinsample.ui.lists.CarsAdapter
import kotlinx.android.synthetic.main.fragment_user.*
import javax.inject.Inject

/**
 * Created by zorin.a on 30.11.2017.
 */

class UserFragment : BaseFragment() {
    //region var
    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory
    @Inject
    internal lateinit var carAdapter: CarsAdapter

    private lateinit var userViewModel: UserViewModel
    //endregion

    //region override
    override fun getLayoutRes(): Int = R.layout.fragment_user

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)

        initObservers()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loginButton.setOnClickListener({ loginUser() })
        getDataButton.setOnClickListener({ getUserData() })
    }
    //endregion

    //region fun
    private fun initObservers() {
        userViewModel.progressData.observe(this, Observer<Boolean> { isProgress ->
            if (isProgress == true) {
                statusView.showProgress()
            } else {
                statusView.hide()
            }
        })
        userViewModel.errorData.observe(this, Observer<Boolean> { isError ->
            if (isError == true) {
                statusView.showError()
            } else {
                statusView.hide()
            }
        })
        userViewModel.loginData.observe(this, Observer<Boolean> { isLogged ->
            if (isLogged == true) {
                userViewModel.getUser()
                showToastMessage(R.string.login_successful)
            } else {
                showToastMessage(R.string.login_fail)
            }
        })
        userViewModel.userData.observe(this, Observer<User> { user ->
            updateUserData(user)
        })
        userViewModel.carsData.observe(this, Observer<List<Car>> { cars ->
            updateCars(cars)
        })
    }

    private fun setupRecyclerView() {
        carsRecyclerView.adapter = carAdapter
        carsRecyclerView.layoutManager = LinearLayoutManager(activity, OrientationHelper.VERTICAL, false)
    }

    private fun loginUser() {
        userViewModel.login()
    }

    private fun getUserData() {
        userViewModel.getUserCars(100, 0)
    }

    private fun updateCars(cars: List<Car>?) {
        if (cars == null) return
        carAdapter.setData(cars)
    }

    private fun updateUserData(user: User?) {
        if (user == null) return
        userName.text = user.name
        userSurName.text = user.surName
        getDataButton.visibility = View.VISIBLE
    }
    //endregion

    companion object {
        private val TAG = "UserFragment"
        fun getInstance(): UserFragment = UserFragment()
    }
}