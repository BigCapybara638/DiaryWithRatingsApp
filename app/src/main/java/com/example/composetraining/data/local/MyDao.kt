package com.example.composetraining.data.local

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface MyDao {

    @Insert
    suspend fun addStudent(studentEntity: StudentEntity)

}