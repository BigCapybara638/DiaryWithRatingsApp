package com.example.composetraining.presentation.screes.studentdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composetraining.R
import com.example.composetraining.presentation.screes.studentdetails.components.DisciplineItem
import com.example.composetraining.presentation.theme.ComposeTrainingTheme

@Composable
fun StudentDetailsScreen(
    itemId: Int?,
    viewModel: StudentsDetailsViewModel
) {
    ComposeTrainingTheme {
        viewModel.loadStudent(itemId!!)

        val student = viewModel.student.collectAsStateWithLifecycle()

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
                modifier = Modifier.fillMaxWidth().padding(0.dp, 0.dp, 0.dp, 20.dp)
            )

            Button(
                onClick = {

                },
                modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 20.dp)
            ) {
                Text(text = "Добавить оценку",
                    fontSize = 18.sp)
            }

            DisciplineItem()
            DisciplineItem()
            DisciplineItem()
            DisciplineItem()
            DisciplineItem()
            DisciplineItem()
            DisciplineItem()
            DisciplineItem()

        }
    }
}