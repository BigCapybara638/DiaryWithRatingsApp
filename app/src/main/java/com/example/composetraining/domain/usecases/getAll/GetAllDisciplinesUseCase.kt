package com.example.composetraining.domain.usecases.getAll

import com.example.composetraining.domain.models.Discipline
import com.example.composetraining.domain.repository.DatabaseRepository

class GetAllDisciplinesUseCase(
    private val databaseRepository: DatabaseRepository
)  {

    suspend operator fun invoke() : List<Discipline> {
        return databaseRepository.getAllDisciplines()
    }
}