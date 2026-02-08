package com.example.composetraining.presentation.screes.home

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.composetraining.domain.models.Student
import com.example.composetraining.presentation.screes.home.components.InputAlertDialog
import com.example.composetraining.presentation.screes.home.components.StudentBox
import com.example.composetraining.presentation.theme.ComposeTrainingTheme


@Composable
fun HomeStudentsScreen(
    context: Context,
    viewModel: HomeViewModel,
    navController: NavHostController,
) {
    ComposeTrainingTheme {
        val uiState = viewModel.dataState.collectAsStateWithLifecycle()

        var showDialog by remember { mutableStateOf(false) }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 70.dp)
        ) {
            Button(
                modifier = Modifier,
                onClick = {
                    showDialog = true
                }
            ) {
                Text("Добавить студента", fontSize = 20.sp)
            }

            when (val state = uiState.value) {
                is DataState.Loading -> {
                    Log.e("test", "loading")
                }

                is DataState.Success -> {
                    LazyColumn(modifier = Modifier.padding(0.dp, 20.dp)) {
                        items(state.student) { student ->
                            StudentBox(
                                student.name,
                                student.surname,
                                {
                                    navController.navigate("student_details/${student.id}")
                                }
                            )
                        }
                    }
                }

                is DataState.Error -> {
                    Toast.makeText(context, "Не удалось загрузить данные", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            if (showDialog) {
                InputAlertDialog(
                    title = "Добавить студента",
                    onDismiss = { showDialog = false },
                    onConfirm = { name, surname ->
                        val student = Student(
                            name = name,
                            surname = surname,
                            pass = "1234"
                        )
                        viewModel.addStudent(student)
                        showDialog = false
                        viewModel.loadData()
                    }
                )
            }
        }
    }
}