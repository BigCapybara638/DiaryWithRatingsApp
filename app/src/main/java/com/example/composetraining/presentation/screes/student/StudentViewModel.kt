package com.example.composetraining.presentation.screes.student

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetraining.data.local.TransactionAnswer
import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.usecases.GetMarksForStudentUseCase
import com.example.composetraining.domain.usecases.GetStudentByIdUseCase
import com.example.composetraining.presentation.screes.home.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentViewModel @Inject constructor(
    private val getStudentByIdUseCase: GetStudentByIdUseCase,
    private val getMarksForStudentUseCase: GetMarksForStudentUseCase
) : ViewModel() {

    private var _student = MutableStateFlow(Student(id = 1, name = "Имя", surname = "Фамилия", pass = "1234"))
    val student: StateFlow<Student> = _student

    private val _dataState = MutableStateFlow<DataState<List<TransactionAnswer>>>(DataState.Loading)
    val dataState: StateFlow<DataState<List<TransactionAnswer>>> = _dataState


    fun loadStudent(id: Int) {
        viewModelScope.launch {
            try {
                _student.value = getStudentByIdUseCase.invoke(id)
            } catch (e: Exception) {
                _dataState.value = DataState.Error(e.message.toString())
                Log.e("loadData", e.message.toString())
            }

        }
    }

    fun loadMarksForStudent(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _dataState.value = DataState.Loading
            try {
                val result = getMarksForStudentUseCase.invoke(id.toLong())
                _dataState.value = DataState.Success(result)
            } catch (e: Exception) {
                _dataState.value = DataState.Error(e.message.toString())
                Log.e("loadData", e.message.toString())
            }
        }
    }

}