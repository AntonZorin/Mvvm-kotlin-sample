package com.az.kotlinsample.common

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by zorin.a on 08.12.2017.
 */
class PrefManager @Inject constructor(context: Context) {

    private val PREFERENCES_NAME_KEY: String = "testing"
    private val sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME_KEY, 0)
    }

    fun seveToken(token: String) {
        sharedPreferences.edit().putString("auth_token", token).apply()
    }

    fun getToken(): String {
        return sharedPreferences.getString("auth_token", "")
    }

    fun deleteToken() {
        sharedPreferences.edit().clear().apply()
    }

}