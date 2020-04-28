package com.example.monikaprime.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    val name: String,
    val user_id: Int,
    val isChecked: Boolean,
    val date: String,
    @PrimaryKey val username: String,
    val rfid: String?,
    val pin: Int
) {
    override fun toString(): String = name
}

