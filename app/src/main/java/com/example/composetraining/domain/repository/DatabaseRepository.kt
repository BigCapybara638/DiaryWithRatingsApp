package com.example.composetraining.domain.repository

import com.example.composetraining.data.local.DisciplineEntity
import com.example.composetraining.data.local.TransactionAnswer
import com.example.composetraining.domain.models.Discipline
import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.models.Teacher
import com.example.composetraining.domain.models.Transaction

interface DatabaseRepository {

    suspend fun addStudent(student: Student)

    suspend fun addDiscipline(discipline: Discipline)

    suspend fun addTransaction(transaction: Transaction) : Boolean

    suspend fun addTeacher(teacher: Teacher)

    suspend fun getStudentById(id: Int) : Student

    suspend fun getAllStudents() : List<Student>

    suspend fun getAllDisciplines() : List<Discipline>

    suspend fun getAllTeachers() : List<Teacher>

    suspend fun getMarksForStudentByID(id: Long) : List<TransactionAnswer>

    suspend fun getAllDisciplinesByStudent(student: Student) : List<Transaction>

    suspend fun getStudentByLoginAndPass(login: String, pass: String) : Student?

    suspend fun changePassForStudent(id: Int, pass: String)
}