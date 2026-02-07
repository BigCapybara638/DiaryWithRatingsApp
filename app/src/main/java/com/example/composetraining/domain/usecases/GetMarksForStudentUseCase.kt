package com.example.composetraining.domain.usecases

import com.example.composetraining.data.local.TransactionAnswer
import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.models.Transaction
import com.example.composetraining.domain.repository.DatabaseRepository

class GetMarksForStudentUseCase(
    private val databaseRepository: DatabaseRepository
) {

    suspend operator fun invoke(
        id: Long
    ) : List<TransactionAnswer> {
        return databaseRepository.getMarksForStudentByID(id)
    }

}