package com.example.composetraining.presentation

import android.os.Bundle
import com.example.composetraining.R
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.composetraining.presentation.theme.ComposeTrainingTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingPreview()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTrainingTheme {
        val openDialog = remember { mutableStateOf(false) }
        Column(modifier = Modifier.fillMaxSize()) {
            StudentBox()
            StudentBox("Legchaeva")
            StudentBox("Petrov")
            StudentBox("Novicov")
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    openDialog.value = true
                }
            ) { Text("Добавить студента", fontSize = 20.sp)
                if (openDialog.value) {
                    AlertDialog(
                        onDismissRequest = { openDialog.value = false},
                        title = { Text(text = "Подтверждение действия") },
                        text = { Text("Вы действительно хотите удалить выбранный элемент?") },
                        confirmButton = {
                            Button({ openDialog.value = false }) {
                                Text("OK", fontSize = 22.sp)
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .border(2.dp, Color.Black)

    ) {
        Text(
            text = name,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(18.dp)
        )
    }
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