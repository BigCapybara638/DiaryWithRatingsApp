package com.example.composetraining.domain.usecases.add

import com.example.composetraining.domain.models.Teacher
import com.example.composetraining.domain.repository.DatabaseRepository
import javax.inject.Inject

// попробовал с Inject вместо создания провайдера
class AddTeacherUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {

    suspend operator fun invoke(
        teacher: Teacher,
    ) {
        return databaseRepository.addTeacher(teacher)
    }

}