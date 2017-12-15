package com.az.kotlinsample.ui.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.util.Log
import android.view.View
import com.az.kotlinsample.R
import com.az.kotlinsample.mvvm.ViewModelFactory
import com.az.kotlinsample.mvvm.models.Car
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
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loginButton.setOnClickListener({ loginUser() })
        getDataButton.setOnClickListener({ getUserData() })
    }
    //endregion

    //region fun
    private fun setupRecyclerView() {
        carsRecyclerView.adapter = carAdapter
        carsRecyclerView.layoutManager = LinearLayoutManager(activity, OrientationHelper.VERTICAL, false)
    }

    private fun getUserData() {
        progressView.showProgress()
        userViewModel.getUserCars(100, 0).subscribe({ r ->
            updateCars(r.cars)
            progressView.hide()
        }, { t -> progressView.showError() })
    }

    private fun updateCars(cars: List<Car>) = carAdapter.setData(cars)

    private fun loginUser() {
        progressView.showProgress()
        userViewModel
                .login()
                .subscribe({ success ->
                    if (success == true) {
                        showToastMessage(R.string.login_successful)
                        userViewModel
                                .getUser()
                                .subscribe({ response ->
                                    updateUserData(response)
                                    progressView.hide()
                                })
                    } else {
                        showToastMessage(R.string.login_fail)
                    }
                }, { progressView.showError() })
    }

    private fun updateUserData(response: ProfileResponse) {
        userName.text = response.user.name
        userSurName.text = response.user.surName
        getDataButton.visibility = View.VISIBLE
    }
    //endregion

    companion object {
        private val TAG = "UserFragment"
        fun getInstance(): UserFragment = UserFragment()
    }
}