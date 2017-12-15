package com.az.kotlinsample.network.request

import com.google.gson.annotations.SerializedName

/**
 * Created by zorin.a on 08.12.2017.
 */
data class LoginRequest(@SerializedName("login") var login: String,
                        @SerializedName("password") var password: String
)