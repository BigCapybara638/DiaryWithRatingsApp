package com.example.composetraining.domain.usecases

import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.repository.DatabaseRepository

class GetVerificationUserUseCase(
    private val databaseRepository: DatabaseRepository
) {

    suspend operator fun invoke(
        login: String,
        pass: String
    ) : Student? {
        return databaseRepository.getStudentByLoginAndPass(login, pass)
    }

}