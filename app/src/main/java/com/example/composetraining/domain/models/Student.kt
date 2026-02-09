package com.example.composetraining.domain.models

data class Student(
    val id: Long = 0,
    val name: String,
    val surname: String,
    val pass: String,
    val lastUpdatePass: Int = 0,
)
