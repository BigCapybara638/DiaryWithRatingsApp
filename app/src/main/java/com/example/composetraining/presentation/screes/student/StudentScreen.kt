package com.example.composetraining.presentation.screes.student

import android.util.Log
import androidx.compose.animation.animateBounds
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.composetraining.R
import com.example.composetraining.domain.models.Transaction
import com.example.composetraining.presentation.NavRoutes
import com.example.composetraining.presentation.screes.home.DataState
import com.example.composetraining.presentation.screes.studentdetails.StudentsDetailsViewModel
import com.example.composetraining.presentation.screes.studentdetails.components.DisciplineItem
import com.example.composetraining.presentation.screes.studentdetails.components.InputDisciplineDialog
import com.example.composetraining.presentation.theme.ComposeTrainingTheme

@Composable
fun StudentScreen(
    itemId: Int?,
    viewModel: StudentViewModel,
    navController: NavHostController
) {
    ComposeTrainingTheme {
        viewModel.loadStudent(itemId!!)
        viewModel.loadMarksForStudent(itemId)

        val student = viewModel.student.collectAsStateWithLifecycle()
        val uiState = viewModel.dataState.collectAsStateWithLifecycle()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()

        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_avatar),
                contentDescription = "Avatar",
                modifier = Modifier
                    .padding(10.dp, 50.dp, 10.dp, 30.dp)
                    .width(270.dp)
                    .height(270.dp)
                    .border(2.dp, Color.Black, RoundedCornerShape(50.dp))
            )

            Text(
                text = student.value.name,
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = student.value.surname,
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(0.dp, 0.dp, 0.dp, 10.dp)
            )

            Button(
                onClick = {
                    navController.navigate(NavRoutes.Authorization.route) {
                        popUpTo(NavRoutes.Authorization.route) { inclusive = true }
                    }
                }
            ) {
                Text("Выйти")
            }

            when(val state = uiState.value) {
                is DataState.Loading -> {
                    Log.e("test", "loading")
                }
                is DataState.Success -> {
                    LazyColumn {
                        items(state.student) { transactions ->
                            DisciplineItem(transactions)
                        }
                    }
                }
                is DataState.Error -> {
                }
            }

        }
    }
}
