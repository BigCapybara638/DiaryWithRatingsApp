package com.example.composetraining.domain.usecases

import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.models.Teacher
import com.example.composetraining.domain.repository.DatabaseRepository

class GetAllTeachersUseCase(
    private val databaseRepository: DatabaseRepository
)  {

    suspend operator fun invoke() : List<Teacher> {
        return databaseRepository.getAllTeachers()
    }
}