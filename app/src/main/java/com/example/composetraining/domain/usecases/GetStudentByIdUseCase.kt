package com.example.composetraining.domain.usecases

import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.repository.DatabaseRepository


class GetStudentByIdUseCase(
    private val databaseRepository: DatabaseRepository
) {

    suspend operator fun invoke(
        id: Int
    ) : Student {
        return databaseRepository.getStudentById(id)
    }

}