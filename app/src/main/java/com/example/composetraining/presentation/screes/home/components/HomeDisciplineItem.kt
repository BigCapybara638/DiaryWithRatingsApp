package com.example.composetraining.presentation.screes.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetraining.domain.models.Discipline

@Composable
fun HomeDisciplineItem(discipline: Discipline) {
    Box(
        modifier = Modifier
            .padding(8.dp, 3.dp)
            .border(1.dp, Color.Black, RoundedCornerShape(12.dp))

    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        {
            Text(
                text = discipline.name,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(2.dp)
                    .fillMaxWidth(0.9f)
            )
        }
    }
}