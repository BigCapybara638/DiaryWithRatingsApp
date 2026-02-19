package com.example.composetraining.domain.models

sealed class Result<out T> {
    data class Success<T>(val result: Student) : Result<T>()
    data class Failure<T>(val error: Exception) : Result<T>()
}