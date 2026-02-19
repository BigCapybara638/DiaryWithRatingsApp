package com.example.composetraining.presentation.screes.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetraining.data.repository.FirestoreRepositoryImpl
import com.example.composetraining.domain.models.Discipline
import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.models.Teacher
import com.example.composetraining.domain.usecases.add.AddDisciplineUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.composetraining.domain.usecases.add.AddStudentUseCase
import com.example.composetraining.domain.usecases.add.AddTeacherUseCase
import com.example.composetraining.domain.usecases.getAll.GetAllDisciplinesUseCase
import com.example.composetraining.domain.usecases.getAll.GetAllStudentsUseCase
import com.example.composetraining.domain.usecases.getAll.GetAllTeachersUseCase
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val addStudentUseCase: AddStudentUseCase,
    private val addDisciplineUseCase: AddDisciplineUseCase,
    private val addTeacherUseCase: AddTeacherUseCase,
    private val getAllStudentsUseCase: GetAllStudentsUseCase,
    private val getAllDisciplinesUseCase: GetAllDisciplinesUseCase,
    private val getAllTeachersUseCase: GetAllTeachersUseCase,
) : ViewModel() {

    private val fire = FirestoreRepositoryImpl()

    private val _dataState = MutableStateFlow<DataState<List<Student>>>(DataState.Loading)
    val dataState: StateFlow<DataState<List<Student>>> = _dataState

    private val _dataDisciplinesState = MutableStateFlow<DataState<List<Discipline>>>(DataState.Loading)
    val dataDisciplinesState: StateFlow<DataState<List<Discipline>>> = _dataDisciplinesState

    private val _dataTeachersState = MutableStateFlow<DataState<List<Teacher>>>(DataState.Loading)
    val dataTeachersState: StateFlow<DataState<List<Teacher>>> = _dataTeachersState


    init {
        loadData()
        loadDiscipline()
        loadTeachers()
    }

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            _dataState.value = DataState.Loading
            try {
                val result = DataState.Success(getAllStudentsUseCase.invoke())
                _dataState.value = result
            } catch (e: Exception) {
                _dataState.value = DataState.Error(e.message.toString())
            }
        }
    }

    fun loadDiscipline() {
        viewModelScope.launch(Dispatchers.IO) {
            _dataDisciplinesState.value = DataState.Loading
            try {
                val result = DataState.Success(getAllDisciplinesUseCase.invoke())
                _dataDisciplinesState.value = result
            } catch (e: Exception) {
                _dataDisciplinesState.value = DataState.Error(e.message.toString())
            }
        }
    }

    fun loadTeachers() {
        viewModelScope.launch(Dispatchers.IO) {
            _dataTeachersState.value = DataState.Loading
            try {
                val result = DataState.Success(getAllTeachersUseCase.invoke())
                _dataTeachersState.value = result
            } catch (e: Exception) {
                _dataTeachersState.value = DataState.Error(e.message.toString())
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
            //addDisciplineUseCase.invoke(discipline)
            fire.addDiscipline(discipline)
        }
    }

    fun addTeacher(teacher: Teacher) {
        Log.e("tests", "addDiscipline")
        viewModelScope.launch {
            addTeacherUseCase.invoke(teacher)
        }
    }
}

sealed class DataState<out T> {
    object Loading : DataState<Nothing>()
    data class Success<T>(val student: T) : DataState<T>()
    data class Error(val errorMessage: String) : DataState<Nothing>()
}