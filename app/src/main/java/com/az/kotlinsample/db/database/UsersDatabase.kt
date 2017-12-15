package com.az.kotlinsample.db.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.az.kotlinsample.db.dao.CarDao
import com.az.kotlinsample.db.dao.UserDao
import com.az.kotlinsample.mvvm.models.Car
import com.az.kotlinsample.mvvm.models.User


/**
 * Created by zorin.a on 29.11.2017.
 */

@Database(entities = [(User::class), (Car::class)], version = 1)
abstract class UsersDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun carDao(): CarDao

    companion object {
        @Volatile private var INSTANCE: UsersDatabase? = null

        fun getInstance(context: Context): UsersDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        UsersDatabase::class.java, "kotlin_sample.db")
                        .build()
    }
}