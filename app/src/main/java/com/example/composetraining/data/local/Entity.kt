package com.example.composetraining.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.composetraining.di.AppModule_ProvideGetAllDisciplinesUseCaseFactory

@Entity(tableName = "students")
data class StudentEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val surname: String,
    val pass: String,
    val lastUpdatePass: Int = 0
)

@Entity(tableName = "discipline")
data class DisciplineEntity(
    // id discipline
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
)

@Entity(tableName = "transactions")
data class TransactionsEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val studentId: Long,
    val disciplineId: Long,
    val point: Int = 3
)

@Entity(tableName = "teachers")
data class TeacherEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val surname: String,
    val pass: String,
    val disciplineId: Long,
)

data class TransactionAnswer(
    @Embedded
    val transactionsEntity: TransactionsEntity,
    val name: String
)