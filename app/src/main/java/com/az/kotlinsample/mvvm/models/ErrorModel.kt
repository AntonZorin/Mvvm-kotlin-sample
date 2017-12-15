package com.az.kotlinsample.mvvm.models

import com.google.gson.annotations.SerializedName

/**
 * Created by zorin.a on 08.12.2017.
 */
class ErrorModel(@SerializedName("code") var code: Int,
                 @SerializedName("message") var message: String)

