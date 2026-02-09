package com.example.composetraining.domain.models

import androidx.room.PrimaryKey

data class Teacher(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val surname: String,
    val pass: String,
    val disciplineId: Long,
)