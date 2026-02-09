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

    @Insert
    suspend fun addTeacher(teacherEntity: TeacherEntity)

    @Query("SELECT * FROM students")
    suspend fun getAllStudents() : List<StudentEntity>

    @Query("SELECT * FROM discipline")
    suspend fun getAllDisciplines() : List<DisciplineEntity>

    @Query("SELECT * FROM teachers")
    suspend fun getAllTeachers() : List<TeacherEntity>

    @Query("SELECT * FROM students WHERE id = :id")
    suspend fun getStudentById(id: Long) : StudentEntity

    @Query("SELECT t1.*, discipline.name FROM transactions t1\n" +
            "JOIN discipline ON discipline.id == t1.disciplineId " +
            "WHERE t1.id IN (\n" +
            "    SELECT MAX(id) FROM transactions t2\n" +
            "    WHERE t2.studentId = :studentId\n" +
            "    GROUP BY t2.disciplineId\n" +
            ")")
    suspend fun getMarksForStudent(studentId: Long) : List<TransactionAnswer>

    @Query("SELECT COUNT(*) > 0 FROM discipline WHERE id = :id")
    suspend fun checkDiscipline(id: Long) : Boolean

    @Query("SELECT * FROM students WHERE surname = :login AND pass = :pass LIMIT 1")
    suspend fun getStudentByLoginAndPass(login: String, pass: String) : StudentEntity?
}