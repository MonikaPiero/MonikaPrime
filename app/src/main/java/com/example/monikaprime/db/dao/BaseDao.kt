package com.example.monikaprime.db.dao

import androidx.room.Insert

interface BaseDao<T> {
    @Insert
    fun insert(vararg obj: T)
}