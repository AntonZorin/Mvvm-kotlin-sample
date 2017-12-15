package com.az.kotlinsample.ui.lists

import android.view.ViewGroup
import com.az.kotlinsample.mvvm.models.Car
import com.az.kotlinsample.ui.lists.item_view.CarItemView
import javax.inject.Inject

/**
 * Created by zorin.a on 14.12.2017.
 */
class CarsAdapter @Inject constructor() : BaseAdapter<Car, CarItemView, BaseViewHolder<CarItemView>>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<CarItemView> =
            BaseViewHolder(CarItemView(parent!!.context))
}