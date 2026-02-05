package com.example.composetraining.domain.usecases

import com.example.composetraining.domain.models.Discipline
import com.example.composetraining.domain.models.Student
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