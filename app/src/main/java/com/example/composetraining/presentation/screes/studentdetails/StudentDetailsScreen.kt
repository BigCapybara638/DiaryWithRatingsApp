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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetraining.R
import com.example.composetraining.presentation.screes.studentdetails.components.DisciplineItem
import com.example.composetraining.presentation.theme.ComposeTrainingTheme

@Composable
fun StudentDetailsScreen(
    itemId: Int?
) {
    ComposeTrainingTheme {
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
                text = "Имя",
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Фамилия",
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
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