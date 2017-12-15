package com.az.kotlinsample.ext

import android.content.Context
import android.widget.Toast

/**
 * Created by zorin.a on 07.12.2017.
 */
fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()