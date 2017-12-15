package com.az.kotlinsample.network.response

import com.az.kotlinsample.mvvm.models.Car
import com.google.gson.annotations.SerializedName

/**
 * Created by zorin.a on 08.12.2017.
 */

data class CarsResponse(
        @SerializedName("cars") val cars: List<Car>): BaseResponse()