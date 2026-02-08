package com.example.composetraining.presentation.screes.home

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController

@Composable
fun HomeDisciplineScreen(
    context: Context,
    viewModel: HomeViewModel,
    navController: NavHostController,
) {

    // val uiState = viewModel.dataState.collectAsStateWithLifecycle()

    var showDialog by remember { mutableStateOf(false) }

}