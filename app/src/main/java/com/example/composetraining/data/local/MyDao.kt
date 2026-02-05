package com.example.composetraining.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.composetraining.domain.models.Student

@Dao
interface MyDao {

    @Insert
    suspend fun addStudent(studentEntity: StudentEntity)

    @Insert
    suspend fun addDiscipline(disciplineEntity: DisciplineEntity)

    @Query("SELECT * FROM students")
    suspend fun getAllStudents() : List<StudentEntity>
}