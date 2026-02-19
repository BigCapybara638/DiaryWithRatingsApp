package com.example.composetraining.data.repository

import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.repository.AuthRepository
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FirebaseAuthRepositoryImpl : AuthRepository {

    val auth = Firebase.auth

    override suspend fun singUp(
        email: String,
        password: String
    ): Result<Student> {
        TODO("Not yet implemented")
        //auth.createUserWithEmailAndPassword(email, password)
    }

    override suspend fun singIn(
        email: String,
        password: String
    ): Result<Student> {
        TODO("Not yet implemented")
    }

    override suspend fun singOut() {
        TODO("Not yet implemented")
    }
}