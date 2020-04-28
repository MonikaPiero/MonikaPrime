package com.example.monikaprime.login

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.monikaprime.db.dao.UserDao
import com.example.monikaprime.utils.get

class LoginViewModel(preferences: SharedPreferences, val userDao: UserDao) : ViewModel() {

    enum class AuthenticationState {
        NOT_REQUIRED,        // Initial state, the user doesn't need to authenticate
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED,        // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }

    val authenticationState = MutableLiveData<AuthenticationState>()
    var username: String

    init {

        if (preferences.get("FirstTimeLogin")) {
            authenticationState.value = AuthenticationState.NOT_REQUIRED

        }
        else
        {
            // In this example, the user is always unauthenticated when MainActivity is launched
            authenticationState.value = AuthenticationState.UNAUTHENTICATED
        }
        username = ""


    }

    fun refuseAuthentication() {
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
    }

    fun authenticate(username: String,password: String) {
        if (passwordIsValidForUsername(username,password)) {
            this.username = username
            authenticationState.value = AuthenticationState.AUTHENTICATED
        } else {
            authenticationState.value = AuthenticationState.INVALID_AUTHENTICATION
        }
    }

    private fun passwordIsValidForUsername(username: String,password: String): Boolean {
        return userDao.getUser(username).equals(password)
    }
}