package com.az.kotlinsample.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.az.kotlinsample.ext.toast
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


/**
 * Created by zorin.a on 30.11.2017.
 */
abstract class BaseFragment : Fragment(), HasSupportFragmentInjector {

    @Inject
    lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?{
           return inflater?.inflate(getLayoutRes(), container, false)}

    abstract fun getLayoutRes(): Int

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = supportFragmentInjector

    internal fun showToastMessage(messageId: Int) {
        val message = activity.getString(messageId)
        activity.applicationContext.toast(message)
    }
}