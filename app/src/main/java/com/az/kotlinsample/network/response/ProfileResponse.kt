package com.az.kotlinsample.network.response

import com.az.kotlinsample.mvvm.models.User
import com.google.gson.annotations.SerializedName

/**
 * Created by zorin.a on 08.12.2017.
 */

data class ProfileResponse(@SerializedName("user") val user: User) : BaseResponse()