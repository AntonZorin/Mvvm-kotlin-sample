package com.az.kotlinsample.network.response

import com.google.gson.annotations.SerializedName

/**
 * Created by zorin.a on 08.12.2017.
 */

data class LoginResponse(
        @SerializedName("authorization_token") val token: String) : BaseResponse()
