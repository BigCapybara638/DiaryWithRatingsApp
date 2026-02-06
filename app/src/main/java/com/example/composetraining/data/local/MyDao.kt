package com.example.composetraining.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.composetraining.domain.models.Student

@Dao
interface MyDao {

    @Insert
    suspend fun addStudent(studentEntity: StudentEntity)

    @Insert
    suspend fun addDiscipline(disciplineEntity: DisciplineEntity)

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun addMark(transactionsEntity: TransactionsEntity)

    @Query("SELECT * FROM students")
    suspend fun getAllStudents() : List<StudentEntity>

    @Query("SELECT * FROM students WHERE id = :id")
    suspend fun getStudentById(id: Long) : StudentEntity

    @Query("SELECT * FROM transactions t1\n" +
            "WHERE t1.id IN (\n" +
            "    SELECT MAX(id) FROM transactions t2\n" +
            "    WHERE t2.studentId = :studentId\n" +
            "    GROUP BY t2.disciplineId\n" +
            ")")
    suspend fun getMarksForStudent(studentId: Long) : List<TransactionsEntity>
}