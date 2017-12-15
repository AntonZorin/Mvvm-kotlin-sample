package com.az.kotlinsample.network.response

import com.az.kotlinsample.mvvm.models.ErrorModel
import com.google.gson.annotations.SerializedName

/**
 * Created by zorin.a on 11.12.2017.
 */

open class BaseResponse {
    @SerializedName("success")
    val isSuccess: Boolean? = false
    @SerializedName("error")
    val error: ErrorModel? = null
}

