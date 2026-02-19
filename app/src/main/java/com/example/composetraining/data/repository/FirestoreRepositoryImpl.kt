package com.example.composetraining.data.repository

import android.util.Log
import com.example.composetraining.data.local.TransactionAnswer
import com.example.composetraining.domain.models.Discipline
import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.models.Teacher
import com.example.composetraining.domain.models.Transaction
import com.example.composetraining.domain.repository.DatabaseRepository
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class FirestoreRepositoryImpl : DatabaseRepository {

    val db = Firebase.firestore

    override suspend fun addStudent(student: Student) {
        TODO("Not yet implemented")
    }

    override suspend fun addDiscipline(discipline: Discipline) {
        Log.e("firebase", "firebase")
        db.collection("disciplines")
            .add(discipline)
            .addOnSuccessListener { documentReference ->
                Log.e("firebase", "add")
            }
            .addOnFailureListener {
                Log.e("firebase", "error")
            }
    }

    override suspend fun addTransaction(transaction: Transaction): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun addTeacher(teacher: Teacher) {
        TODO("Not yet implemented")
    }

    override suspend fun getStudentById(id: Int): Student {
        TODO("Not yet implemented")
    }

    override suspend fun getAllStudents(): List<Student> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllDisciplines(): List<Discipline> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllTeachers(): List<Teacher> {
        TODO("Not yet implemented")
    }

    override suspend fun getMarksForStudentByID(id: Long): List<TransactionAnswer> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllDisciplinesByStudent(student: Student): List<Transaction> {
        TODO("Not yet implemented")
    }

    override suspend fun getStudentByLoginAndPass(
        login: String,
        pass: String
    ): Student? {
        TODO("Not yet implemented")
    }

    override suspend fun changePassForStudent(id: Int, pass: String) {
        TODO("Not yet implemented")
    }

}