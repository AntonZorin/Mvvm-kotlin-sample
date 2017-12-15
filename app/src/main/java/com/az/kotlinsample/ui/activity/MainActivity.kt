package com.az.kotlinsample.ui.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.widget.Toast
import com.az.kotlinsample.R
import com.az.kotlinsample.mvvm.ViewModelFactory
import com.az.kotlinsample.mvvm.viewmodel.MainActivityViewModel
import com.az.kotlinsample.mvvm.viewmodel.UserViewModel
import com.az.kotlinsample.ui.screens.USERS_SCREEN
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject


class MainActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: MainActivityViewModel
    @Inject
    lateinit var navigatorHolder: NavigatorHolder


    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)
        viewModel.switchScreen(USERS_SCREEN, null)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}
