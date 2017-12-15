package com.az.kotlinsample.ui.lists.item_view

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import com.az.kotlinsample.R
import com.az.kotlinsample.mvvm.models.Car
import com.az.kotlinsample.ui.lists.ViewModel
import kotlinx.android.synthetic.main.item_view_car.view.*

/**
 * Created by zorin.a on 14.12.2017.
 */
class CarItemView : ConstraintLayout, ViewModel<Car> {
    private lateinit var data: Car

    init {
        View.inflate(context, R.layout.item_view_car, this)
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun setData(data: Car) {
        carItemBrand.text = data.brand
        carItemModel.text = data.model
        this.data = data
    }

}
