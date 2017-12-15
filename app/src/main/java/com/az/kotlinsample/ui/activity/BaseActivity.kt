package com.az.kotlinsample.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.az.kotlinsample.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject
import ru.terrakok.cicerone.commands.Command
import android.support.v4.app.FragmentTransaction
import com.az.kotlinsample.ext.toast
import com.az.kotlinsample.ui.fragment.UserFragment
import com.az.kotlinsample.ui.screens.USERS_SCREEN
import ru.terrakok.cicerone.android.SupportFragmentNavigator


/**
 * Created by zorin.a on 29.11.2017.
 */

abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {
    private var disposable = CompositeDisposable()

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    val navigator = object : SupportFragmentNavigator(supportFragmentManager, R.id.container) {
        override fun createFragment(screenKey: String, data: Any?): Fragment? =
                when (screenKey) {
                    USERS_SCREEN -> UserFragment.getInstance()
//                Screens.SELECT_PHOTO_SCREEN -> return SelectPhotoFragment.getNewInstance(data as Int)
                    else -> null
                }

        override fun showSystemMessage(message: String) {
            toast(message)
        }

        override fun exit() {
            finish()
        }

        override fun setupFragmentTransactionAnimation(command: Command?, currentFragment: Fragment?, nextFragment: Fragment?, fragmentTransaction: FragmentTransaction?) {
            super.setupFragmentTransactionAnimation(command, currentFragment, nextFragment, fragmentTransaction)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }

    abstract fun getLayoutRes(): Int

    fun addDisposable(observable: Disposable) {
        disposable.add(observable)
    }
}