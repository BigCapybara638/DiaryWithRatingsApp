package com.example.composetraining.data.repository

import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.models.Transaction
import com.example.composetraining.domain.repository.DatabaseRepository
import com.example.composetraining.data.local.MyDao
import com.example.composetraining.data.mappers.toDomain
import com.example.composetraining.data.mappers.toEntity
import com.example.composetraining.domain.models.Discipline

class DatabaseRepositoryImpl(
    private val dao: MyDao
) : DatabaseRepository {

    override suspend fun addStudent(student: Student) {
        dao.addStudent(student.toEntity())
    }

    override suspend fun addDiscipline(discipline: Discipline) {
        dao.addDiscipline(discipline.toEntity())
    }

    override suspend fun getStudentById(id: Int): Student {
        return dao.getStudentById(id.toLong()).toDomain()
    }

    override suspend fun getAllStudents(): List<Student> {
        return dao.getAllStudents().map { it.toDomain() }
    }

    override suspend fun getAllDisciplinesByStudent(student: Student): List<Transaction> {
        return emptyList()
    }
}