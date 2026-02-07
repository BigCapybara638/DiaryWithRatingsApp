package com.example.composetraining.domain.repository

import com.example.composetraining.data.local.TransactionAnswer
import com.example.composetraining.domain.models.Discipline
import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.models.Transaction

interface DatabaseRepository {

    suspend fun addStudent(student: Student)

    suspend fun addDiscipline(discipline: Discipline)

    suspend fun addTransaction(transaction: Transaction) : Boolean

    suspend fun getStudentById(id: Int) : Student

    suspend fun getAllStudents() : List<Student>

    suspend fun getMarksForStudentByID(id: Long) : List<TransactionAnswer>

    suspend fun getAllDisciplinesByStudent(student: Student) : List<Transaction>

}