package com.example.composetraining.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.composetraining.R
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.composetraining.presentation.theme.ComposeTrainingTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composetraining.domain.models.Discipline
import com.example.composetraining.domain.models.Student

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen(this, viewModel)
        }
    }
}

@Composable
fun MainScreen(
    context: Context,
    viewModel: HomeViewModel
) {
    ComposeTrainingTheme {
        var showDialog by remember { mutableStateOf(false) }
        var showDialogDiscipline by remember { mutableStateOf(false) }

        val uiState = viewModel.data_state.collectAsStateWithLifecycle()

        when(val state = uiState.value) {
            is DataState.Loading -> {
                Log.e("test", "loading")
            }
            is DataState.Success -> {
                LazyColumn {
                    items(state.student) { student ->
                        StudentBox(student.name, student.surname)
                    }
                }
            }
            is DataState.Error -> {
                Toast.makeText(context, "Не удалось загрузить данные", Toast.LENGTH_SHORT).show()
            }
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(60.dp, 70.dp)
        ) {

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    showDialog = true
                }
            ) {
                Text("Добавить студента", fontSize = 20.sp)
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    showDialogDiscipline = true
                }
            ) {
                Text("Добавить дисциплину", fontSize = 20.sp)
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
                        pass = "1234")
                    viewModel.addStudent(student)
                    viewModel.loadData()
                    showDialog = false
                }
            )
        }

        if (showDialogDiscipline) {
            InputAlertDialog(
                title = "Добавить дисциплину",
                onDismiss = { showDialogDiscipline = false },
                onConfirm = { id, name ->
                    val discipline = Discipline(
                        name = name)
                    viewModel.addDiscipline(discipline)
                    showDialogDiscipline = false
                }
            )
        }
    }
}

@Composable
fun InputAlertDialog(
    title: String,
    initialName: String = "",
    initialSurname: String = "",
    onDismiss: () -> Unit,
    onConfirm: (String, String) -> Unit
) {
    var name by remember { mutableStateOf(initialName) }
    var surname by remember { mutableStateOf(initialSurname) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = title) },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Поле для имени
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Имя") },
                    placeholder = { Text("Введите имя") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    )
                )

                // Поле для фамилии
                OutlinedTextField(
                    value = surname,
                    onValueChange = { surname = it },
                    label = { Text("Фамилия") },
                    placeholder = { Text("Введите фамилию") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    )
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm(name, surname)
                    Log.e("tests", "textButtonTap")

                          },
                enabled = name.isNotBlank() && surname.isNotBlank()
            ) {
                Text("Добавить", fontWeight = FontWeight.Bold)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Отмена")
            }
        }
    )
}

@Composable
fun StudentBox(name: String = "Simon", surname: String = "Pavlov") {

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Black)
                .padding(10.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_avatar),
                contentDescription = "People",
                modifier = Modifier
                        .padding(2.dp)
            )
            Text(
                text = name,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(2.dp)

            )

            Text(
                text = surname,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(2.dp)

            )
        }
    }
}