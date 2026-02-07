package com.example.composetraining.presentation.screes.authorization

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.usecases.GetVerificationUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val getVerificationUserUseCase: GetVerificationUserUseCase
) : ViewModel() {

    private var _authorize = MutableStateFlow<Authorize<Student>>(Authorize.START)
    val authorize: StateFlow<Authorize<Student>> = _authorize

    fun authorization(login: String, pass: String) {
        viewModelScope.launch {
            if (login == "admin" && pass == "12345") {
                _authorize.value = Authorize.ADMIN
            } else {
                try {
                    val result = getVerificationUserUseCase.invoke(login, pass)
                    if (result == null) {
                        _authorize.value = Authorize.UNVERIFY
                        Log.e("loadData", "k")
                    } else {
                        _authorize.value = Authorize.STUDENT(result)
                    }
                } catch (e: Exception) {
                    Log.e("loadData", e.message.toString())
                    _authorize.value = Authorize.UNVERIFY
                }
            }
        }
    }

    fun cleanAuthorize() {
        _authorize.value = Authorize.START
    }
}



sealed class Authorize<out T> {
    object START: Authorize<Nothing>()
    object ADMIN : Authorize<Nothing>()
    data class STUDENT<T>(val student: Student) : Authorize<T>()
    object UNVERIFY : Authorize<Nothing>()
}