package com.example.composetraining.presentation

import android.content.Context
import android.os.Bundle
import com.example.composetraining.R
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composetraining.presentation.screes.authorization.AuthorizationScreen
import com.example.composetraining.presentation.screes.authorization.AuthorizationViewModel
import com.example.composetraining.presentation.screes.home.HomeDisciplineScreen
import dagger.hilt.android.AndroidEntryPoint
import com.example.composetraining.presentation.screes.home.HomeScreen
import com.example.composetraining.presentation.screes.home.HomeStudentsScreen
import com.example.composetraining.presentation.screes.home.HomeTeachersScreen
import com.example.composetraining.presentation.screes.home.HomeViewModel
import com.example.composetraining.presentation.screes.student.StudentScreen
import com.example.composetraining.presentation.screes.studentdetails.StudentDetailsScreen
import com.example.composetraining.presentation.screes.studentdetails.StudentsDetailsViewModel
import com.example.composetraining.presentation.screes.student.StudentViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()
    private val studentDetailsViewModel: StudentsDetailsViewModel by viewModels()
    private val studentViewModel: StudentViewModel by viewModels()
    private val authorizationViewModel: AuthorizationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main(this, homeViewModel, studentDetailsViewModel, authorizationViewModel, studentViewModel)
        }
    }
}

@Composable
fun Main(
    context: Context,
    homeViewModel: HomeViewModel,
    studentDetailsViewModel: StudentsDetailsViewModel,
    authorizationViewModel: AuthorizationViewModel,
    studentViewModel: StudentViewModel
    ) {
    val navController = rememberNavController()
    Column(Modifier.padding(8.dp)) {
        NavHost(navController, startDestination = NavRoutes.Authorization.route ) {
            composable(NavRoutes.Authorization.route) {
                AuthorizationScreen(context, navController, authorizationViewModel)
            }
            composable(NavRoutes.Home.route) {
                HomeScreen(context, homeViewModel, navController)
            }
            composable(NavRoutes.HomeStudents.route) {
                HomeStudentsScreen(context, homeViewModel, navController)
            }
            composable(NavRoutes.HomeDiscipline.route) {
                HomeDisciplineScreen(context, homeViewModel, navController)
            }
            composable(NavRoutes.HomeTeachers.route) {
                HomeTeachersScreen(context, homeViewModel, navController)
            }

            composable(
                "${NavRoutes.StudentDetails.route}/{itemId}",
                arguments = listOf(navArgument("itemId") {
                    type = NavType.IntType
                })
            ) { backStackEntry ->
                val itemId = backStackEntry.arguments?.getInt("itemId")
                StudentDetailsScreen(
                    itemId = itemId,
                    viewModel = studentDetailsViewModel
                )
            }
            composable("${NavRoutes.Student.route}/{itemId}",
                arguments = listOf(navArgument("itemId") {
                    type = NavType.IntType
                })
            ) { backStackEntry ->
                    val itemId = backStackEntry.arguments?.getInt("itemId")
                    StudentScreen(itemId, studentViewModel, navController)
            }
        }
    }
}

sealed class NavRoutes(val route: String) {
    object Authorization : NavRoutes("authorization")
    object Home : NavRoutes("home")
    object HomeStudents : NavRoutes("home_students")
    object HomeDiscipline : NavRoutes("home_disciplines")
    object HomeTeachers : NavRoutes("home_teachers")
    object StudentDetails : NavRoutes("student_details")
    object Student : NavRoutes("student")
}