package com.example.composetraining.domain.usecases.add

import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.repository.DatabaseRepository

class AddStudentUseCase(
    private val databaseRepository: DatabaseRepository
) {

    suspend operator fun invoke(
        student: Student,
    ) {
        return databaseRepository.addStudent(student)
    }

}