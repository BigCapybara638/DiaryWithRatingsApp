package com.example.composetraining.presentation.screes.authorization

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.composetraining.domain.models.Student
import com.example.composetraining.presentation.NavRoutes
import com.example.composetraining.presentation.theme.ComposeTrainingTheme

@Composable
fun AuthorizationScreen(
    context: Context,
    navController: NavHostController,
    viewModel: AuthorizationViewModel
) {
    ComposeTrainingTheme {
        var login by remember { mutableStateOf("") }
        var pass by remember { mutableStateOf("") }

        val authorize = viewModel.authorize.collectAsStateWithLifecycle()

        LaunchedEffect(authorize.value) {
            when (authorize.value) {
                is Authorize.ADMIN -> {
                    navController.navigate(NavRoutes.Home.route) {
                        popUpTo(NavRoutes.Authorization.route) { inclusive = true }
                    }
                }
                is Authorize.STUDENT -> {
                    navController.navigate("${NavRoutes.Student.route}/${(authorize.value as Authorize.STUDENT<Student>).student.id}") {
                        popUpTo(NavRoutes.Authorization.route) { inclusive = true }
                    }
                }
                is Authorize.UNVERIFY -> {
                    Toast.makeText(context, "Пользователь не найден", Toast.LENGTH_SHORT).show()
                }

                Authorize.START -> {}
            }
            viewModel.cleanAuthorize()
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, 20.dp)
        ) {
            Text(
                text = "Добро пожаловать!",
                textAlign = TextAlign.Center,
                fontSize = 26.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 120.dp, 0.dp, 30.dp)
            )

            OutlinedTextField(
                value = login,
                onValueChange = { login = it },
                label = { Text("Логин") },
                placeholder = { Text("Введите логин (фамилия)") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                )
            )
            OutlinedTextField(
                value = pass,
                onValueChange = { pass = it },
                label = { Text("Пароль") },
                placeholder = { Text("Введите пароль") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                )
            )

            Button(
                modifier = Modifier.padding(0.dp, 20.dp),
                onClick = {
                    viewModel.authorization(login, pass)
                }
            ) {
                Text("Войти")
            }
        }
    }
}