package com.example.composetraining.domain.usecases.add

import com.example.composetraining.domain.models.Discipline
import com.example.composetraining.domain.repository.DatabaseRepository

class AddDisciplineUseCase(
    private val databaseRepository: DatabaseRepository
) {

    suspend operator fun invoke(
        discipline: Discipline,
    ) {
        return databaseRepository.addDiscipline(discipline)
    }

}