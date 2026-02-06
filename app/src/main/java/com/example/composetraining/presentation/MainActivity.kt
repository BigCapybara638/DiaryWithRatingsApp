package com.example.composetraining.presentation

import android.content.Context
import android.os.Bundle
import com.example.composetraining.R
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import com.example.composetraining.presentation.screes.home.HomeScreen
import com.example.composetraining.presentation.screes.home.HomeViewModel
import com.example.composetraining.presentation.screes.student.StudentScreen
import com.example.composetraining.presentation.screes.studentdetails.StudentDetailsScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Main(this, viewModel)
            // HomeScreen(this, viewModel)
        }
    }
}

@Composable
fun Main(context: Context, viewModel: HomeViewModel) {
    val navController = rememberNavController()
    Column(Modifier.padding(8.dp)) {
        NavHost(navController, startDestination = NavRoutes.Home.route ) {
            composable(NavRoutes.Home.route) { HomeScreen(context, viewModel, navController) }
            composable(
                "${NavRoutes.StudentDetails.route}/{itemId}",
                arguments = listOf(navArgument("itemId") { type = NavType.IntType })
            ) { backStackEntry ->
                val itemId = backStackEntry.arguments?.getInt("itemId")
                StudentDetailsScreen(itemId = itemId)
            }
            composable(NavRoutes.Student.route) { StudentScreen() }
        }
    }
}

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object StudentDetails : NavRoutes("student_details")
    object Student : NavRoutes("student")
}