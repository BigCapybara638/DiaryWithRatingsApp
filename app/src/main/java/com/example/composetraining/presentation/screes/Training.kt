package com.example.composetraining.presentation.screes

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetraining.ComposeTrainingApp
import com.example.composetraining.presentation.theme.ComposeTrainingTheme

data class Language(
    val language: String,
    val color: Color
)

@Preview(showBackground = true)
@Composable
fun Training() {
    ComposeTrainingTheme {

    }
}

@Preview(showBackground = true)
@Composable
fun LazyHorizontalGridDemonstrate() {
    LazyHorizontalGrid(
        // количество строк
        rows = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        userScrollEnabled = true,    // установить прокрутку
    ) {
        val itemList: List<Language> = listOf(Language(
            "Kotlin", Color.Red),
            Language(
                "Java", Color.Yellow),
            Language(
                "Python", Color.Cyan),
            Language(
                "C#", Color.Blue),
            Language(
                "C++", Color.LightGray),
            Language(
                "C", Color.LightGray),
            Language(
                "Swift", Color.LightGray)
        )

        items(itemList) { item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(4.dp)
            ) {
                Box(modifier = Modifier
                    .size(100.dp)
                    .background(item.color))
                Text(text = item.language,
                    modifier = Modifier
                        .padding(4.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LazyVerticalGridDemonstrate() {
    LazyVerticalGrid(
        // количество столбцов
        columns = GridCells.Adaptive(120.dp),
        modifier = Modifier.fillMaxSize(),
        userScrollEnabled = true,    // установить прокрутку
    ) {
        val itemList: List<Language> = listOf(Language(
            "Kotlin", Color.Red),
            Language(
                "Java", Color.Yellow),
            Language(
                "Python", Color.Cyan),
            Language(
                "C#", Color.Blue),
            Language(
                "C++", Color.LightGray),
            Language(
                "C", Color.LightGray),
            Language(
                "Swift", Color.LightGray)
        )

        items(itemList) { item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(4.dp)
            ) {
                Box(modifier = Modifier
                    .size(100.dp)
                    .background(item.color))
                Text(text = item.language,
                    modifier = Modifier
                        .padding(4.dp)
                )
            }
        }
    }
}

