package com.az.kotlinsample.ui.lists

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by zorin.a on 14.12.2017.
 */
class BaseViewHolder<out T1 : View> constructor(val view: T1) : RecyclerView.ViewHolder(view)