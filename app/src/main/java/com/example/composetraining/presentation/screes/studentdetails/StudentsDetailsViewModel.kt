package com.example.composetraining.presentation.screes.studentdetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.models.Transaction
import com.example.composetraining.domain.usecases.AddMarkUseCase
import com.example.composetraining.domain.usecases.GetStudentByIdUseCase
import com.example.composetraining.presentation.screes.home.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentsDetailsViewModel @Inject constructor(
    private val getStudentByIdUseCase: GetStudentByIdUseCase,
    private val addMarkUseCase: AddMarkUseCase
) : ViewModel() {

    private var _student = MutableStateFlow(Student(id = 1, name = "Имя", surname = "Фамилия", pass = "1234"))
    val student: StateFlow<Student> = _student
    fun loadStudent(id: Int) {
        viewModelScope.launch {
            try {
                _student.value = getStudentByIdUseCase.invoke(id)
            } catch (e: Exception) {
                Log.e("loadData", e.message.toString())
            }

        }
    }

    fun addMark(transaction: Transaction) {
        viewModelScope.launch {
            addMarkUseCase.invoke(transaction)
        }
    }


}