package com.example.composetraining.presentation.screes.home

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.composetraining.domain.models.Discipline
import com.example.composetraining.domain.models.Student
import com.example.composetraining.presentation.NavRoutes
import com.example.composetraining.presentation.screes.authorization.Authorize
import com.example.composetraining.presentation.screes.home.DataState
import com.example.composetraining.presentation.screes.home.components.InputAlertDialog
import com.example.composetraining.presentation.screes.home.components.InputDisciplineDialog
import com.example.composetraining.presentation.screes.home.components.StudentBox
import com.example.composetraining.presentation.theme.ComposeTrainingTheme

@Composable
fun HomeScreen(
    context: Context,
    viewModel: HomeViewModel,
    navController: NavHostController,
) {
    ComposeTrainingTheme {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 70.dp)
        ) {

            Text(
                text = "Админ - панель",
                textAlign = TextAlign.Center,
                fontSize = 26.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 100.dp, 0.dp, 20.dp)
            )

            Button(
                modifier = Modifier,
                onClick = {
                    navController.navigate(NavRoutes.HomeStudents.route)
                }
            ) {
                Text("Студенты", fontSize = 20.sp)
            }

            Button(
                modifier = Modifier,
                onClick = {
                    navController.navigate(NavRoutes.HomeDiscipline.route)
                }
            ) {
                Text("Дисциплины", fontSize = 20.sp)
            }

            Button(
                modifier = Modifier,
                onClick = {

                }
            ) {
                Text("Преподаватели", fontSize = 20.sp)
            }

        }
    }
}