package com.example.monikaprime.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.monikaprime.db.dao.UserDao
import com.example.monikaprime.db.entity.User

@Database(entities = [User::class], version = 1)
abstract class MonikaDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

