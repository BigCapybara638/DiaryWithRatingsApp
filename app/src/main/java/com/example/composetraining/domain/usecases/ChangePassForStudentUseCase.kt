package com.example.composetraining.domain.usecases

import com.example.composetraining.domain.repository.DatabaseRepository

class ChangePassForStudentUseCase(
    private val databaseRepository: DatabaseRepository
) {

    suspend operator fun invoke(
        id: Int,
        pass: String
    ) {
        return databaseRepository.changePassForStudent(id, pass)
    }
}