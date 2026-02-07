package com.example.composetraining.presentation.screes.studentdetails.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetraining.data.local.TransactionAnswer
import com.example.composetraining.domain.models.Transaction


@Composable
fun DisciplineItem(transactionAnswer: TransactionAnswer) {
    Box(
        modifier = Modifier
            .padding(8.dp, 3.dp)
            .border(1.dp, Color.Black, RoundedCornerShape(12.dp))

    ) {
        Row(Modifier
            .fillMaxWidth()
            .padding(10.dp))
        {
            Text(
                text = transactionAnswer.name,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(2.dp)
                    .fillMaxWidth(0.9f)
            )

            val pount = transactionAnswer.transactionsEntity.point
            val pointMod = when (pount) {
                5 -> Modifier.clip(RoundedCornerShape(6.dp)).background(Color.Green)
                4 -> Modifier.clip(RoundedCornerShape(6.dp)).background(Color.Green)
                3 -> Modifier.clip(RoundedCornerShape(6.dp)).background(Color.Yellow)
                2 -> Modifier.clip(RoundedCornerShape(6.dp)).background(Color.Red)
                else -> {Modifier.clip(RoundedCornerShape(6.dp)).background(Color.Gray)
                }
            }

            Text(
                text = pount.toString(),
                fontSize = 18.sp,
                textAlign = TextAlign.End,
                modifier = pointMod
                    .padding(2.dp)
            )
        }
    }
}