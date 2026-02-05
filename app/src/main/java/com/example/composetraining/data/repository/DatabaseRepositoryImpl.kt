package com.example.composetraining.data.repository

import androidx.room.Database
import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.models.Transaction
import com.example.composetraining.domain.repository.DatabaseRepository
import com.example.composetraining.data.local.MyDao
import com.example.composetraining.data.local.MyDatabase
import com.example.composetraining.data.mappers.toEntity

class DatabaseRepositoryImpl(
    private val dao: MyDao
) : DatabaseRepository {

    override suspend fun addStudent(student: Student) {
        dao.addStudent(student.toEntity())
    }

    override suspend fun getAllStudents(): List<Student> {
        return dao.getAllStudents()
    }

    override suspend fun getAllDisciplinesByStudent(student: Student): List<Transaction> {
        return emptyList()
    }
}