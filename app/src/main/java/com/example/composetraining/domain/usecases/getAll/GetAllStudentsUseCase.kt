package com.example.composetraining.domain.usecases.getAll

import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.repository.DatabaseRepository

class GetAllStudentsUseCase(
    private val databaseRepository: DatabaseRepository
)  {

    suspend operator fun invoke() : List<Student> {
        return databaseRepository.getAllStudents()
    }
}