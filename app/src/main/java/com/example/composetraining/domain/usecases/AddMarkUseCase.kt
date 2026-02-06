package com.example.composetraining.domain.usecases

import com.example.composetraining.domain.models.Transaction
import com.example.composetraining.domain.repository.DatabaseRepository

class AddMarkUseCase(
    private val databaseRepository: DatabaseRepository
) {

    suspend operator fun invoke(
        transaction: Transaction
    ) {
        databaseRepository.addTransaction(transaction)
    }

}