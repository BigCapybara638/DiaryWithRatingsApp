package com.example.composetraining.domain.repository

import com.example.composetraining.domain.models.Discipline
import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.models.Transaction

interface DatabaseRepository {

    suspend fun addStudent(student: Student)

    suspend fun addDiscipline(discipline: Discipline)

    suspend fun getAllStudents() : List<Student>
    suspend fun getAllDisciplinesByStudent(student: Student) : List<Transaction>

}