package com.az.kotlinsample.mvvm.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by zorin.a on 08.12.2017.
 */
@Entity(tableName = "Cars")
data class Car(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val dbId: Long,
        @ColumnInfo(name = "car_id")
        @SerializedName("id")
        val id: Int,
        @ColumnInfo(name = "brand")
        @SerializedName("car_brand")
        val brand: String,
        @ColumnInfo(name = "car_model")
        @SerializedName("model")
        val model: String,
        @ColumnInfo(name = "car_image")
        @SerializedName("image")
        val image: String,
        @ColumnInfo(name = "car_year")
        @SerializedName("year")
        val year: Int
)
