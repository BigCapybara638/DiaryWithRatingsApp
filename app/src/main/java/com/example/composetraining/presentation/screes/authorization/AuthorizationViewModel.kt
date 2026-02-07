package com.example.composetraining.presentation.screes.authorization

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

enum class Authorize {ADMIN, STUDENT, TEACHER}


@HiltViewModel
class AuthorizationViewModel @Inject constructor() : ViewModel() {

    fun authorization(login: String, pass: String) : Authorize {
        if (login == "admin" && pass == "12345") {
            return Authorize.ADMIN
        } else {
            return Authorize.STUDENT
        }
    }

}