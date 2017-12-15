package com.az.kotlinsample.ui.custom_views

import android.content.ContentValues.TAG
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import com.az.kotlinsample.R
import kotlinx.android.synthetic.main.fragment_user.view.*
import kotlinx.android.synthetic.main.view_status.view.*

/**
 * Created by zorin.a on 12.12.2017.
 */

class StatusView : FrameLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_status, this, true)
    }

    fun showProgress() {
        Log.v(TAG, "showProgress")
        progressBar.visibility = View.VISIBLE
        messageText.visibility = View.GONE
    }

    fun showError() {
        Log.v(TAG, "showError")
        messageText.text = context.getString(R.string.error)
        messageText.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    fun hide() {
        Log.v(TAG, "hide")
        progressBar.visibility = View.GONE
        messageText.visibility = View.GONE
    }

    companion object {
        private val TAG: String = "StatusView"
    }
}