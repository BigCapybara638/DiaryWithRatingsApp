package com.example.composetraining.presentation.screes.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetraining.domain.models.Discipline
import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.usecases.AddDisciplineUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.composetraining.domain.usecases.AddStudentUseCase
import com.example.composetraining.domain.usecases.GetAllStudentsUseCase
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val addStudentUseCase: AddStudentUseCase,
    private val addDisciplineUseCase: AddDisciplineUseCase,
    private val getAllStudentsUseCase: GetAllStudentsUseCase,

) : ViewModel() {

    private val _data_state = MutableStateFlow<DataState<List<Student>>>(DataState.Loading)
    val data_state: StateFlow<DataState<List<Student>>> = _data_state

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            _data_state.value = DataState.Loading
            try {
                val result = DataState.Success(getAllStudentsUseCase.invoke())
                _data_state.value = result
            } catch (e: Exception) {
                _data_state.value = DataState.Error(e.message.toString())
            }
        }
    }

    fun addStudent(student: Student) {
        Log.e("tests", "addStudent")
        viewModelScope.launch {
            addStudentUseCase.invoke(student)
        }
    }

    fun addDiscipline(discipline: Discipline) {
        Log.e("tests", "addDiscipline")
        viewModelScope.launch {
            addDisciplineUseCase.invoke(discipline)
        }
    }
}

sealed class DataState<out T> {
    object Loading : DataState<Nothing>()
    data class Success<T>(val student: T) : DataState<T>()
    data class Error(val errorMessage: String) : DataState<Nothing>()
}