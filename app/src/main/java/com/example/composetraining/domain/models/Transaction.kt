package com.example.composetraining.domain.models

import com.example.composetraining.data.local.DisciplineEntity
import com.example.composetraining.data.local.StudentEntity

data class Transaction(
    val id: Long = 0,
    val student: Long,
    val discipline: Long,
    val point: Int = 3
)