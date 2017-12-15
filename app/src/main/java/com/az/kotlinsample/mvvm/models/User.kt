package com.az.kotlinsample.mvvm.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull

/**
 * Created by zorin.a on 08.12.2017.
 */
@Entity(tableName = "Users")
data class User(@PrimaryKey(autoGenerate = true)
                @ColumnInfo(name = "id")
                @NonNull
                var dbId: Long = 1,
                @ColumnInfo(name = "user_id")
                @SerializedName("id") val id: Int,
                @ColumnInfo(name = "user_name")
                @SerializedName("name") val name: String,
                @ColumnInfo(name = "user_surname")
                @SerializedName("surname") val surName: String,
                @ColumnInfo(name = "user_image")
                @SerializedName("image") val image: String,
                @ColumnInfo(name = "user_age")
                @SerializedName("age") val age: Int,
                @ColumnInfo(name = "user_weight")
                @SerializedName("weight") val weigh: Float
)