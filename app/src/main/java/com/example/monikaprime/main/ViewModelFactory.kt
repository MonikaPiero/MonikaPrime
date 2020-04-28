package com.example.monikaprime.main

import android.app.Activity
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.monikaprime.db.MonikaDatabase
import com.example.monikaprime.login.LoginViewModel


class ViewModelFactory(private val activity: Activity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, MonikaDatabase::class.java, "user").build()
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel( PreferenceManager.getDefaultSharedPreferences(activity), db.userDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}