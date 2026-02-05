package com.example.composetraining.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.repository.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.composetraining.domain.usecases.AddStudentUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val addStudentUseCase: AddStudentUseCase

) : ViewModel() {

    private val _data_state = MutableStateFlow<DataState<List<Student>>>(DataState.Loading)
    val data_state: StateFlow<DataState<List<Student>>> = _data_state

    fun load_data(id: Int) {

    }

    fun addStudent(student: Student) {
        viewModelScope.launch {
            addStudentUseCase(student)
        }
    }
}

sealed class DataState<out T> {
    object Loading : DataState<Nothing>()
    data class Success<T>(val student: T) : DataState<T>()
    data class Error(val errorMessage: String) : DataState<Nothing>()
}