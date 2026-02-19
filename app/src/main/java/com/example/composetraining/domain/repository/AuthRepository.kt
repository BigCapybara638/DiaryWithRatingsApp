package com.example.composetraining.domain.repository

import com.example.composetraining.domain.models.Student
import com.example.composetraining.presentation.NavRoutes

interface AuthRepository {

    suspend fun singUp(email: String, password: String) : Result<Student>

    suspend fun singIn(email: String, password: String) : Result<Student>

    suspend fun singOut()


}