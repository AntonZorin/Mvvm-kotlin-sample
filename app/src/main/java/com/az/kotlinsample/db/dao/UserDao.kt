package com.az.kotlinsample.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.az.kotlinsample.mvvm.models.User

import io.reactivex.Flowable

/**
 * Created by zorin.a on 29.11.2017.
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM Users WHERE user_id = :id")
    fun getUserById(id: String): Flowable<User>

    @Query("SELECT * FROM Users WHERE user_name = :name")
    fun getUserByName(name: String): Flowable<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("DELETE FROM Users")
    fun deleteUsers()
}