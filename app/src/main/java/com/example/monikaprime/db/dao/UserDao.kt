package com.example.monikaprime.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.monikaprime.db.entity.User


@Dao
abstract class UserDao : BaseDao<User>
{
    @Query("DELETE FROM User")
    abstract fun nukeTable()

    @Query("SELECT * FROM User")
    abstract fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM User WHERE username =:username")
    abstract fun getUser(username: String): User
}