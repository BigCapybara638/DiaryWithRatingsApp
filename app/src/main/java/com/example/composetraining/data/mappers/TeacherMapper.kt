package com.example.composetraining.data.mappers

import com.example.composetraining.data.local.TeacherEntity
import com.example.composetraining.domain.models.Teacher

fun TeacherEntity.toDomain() : Teacher {
    return Teacher(
        id = this.id,
        name = this.name,
        surname = this.surname,
        pass = this.pass,
        disciplineId = this.disciplineId
    )
}

fun Teacher.toEntity() : TeacherEntity {
    return TeacherEntity(
        id = this.id,
        name = this.name,
        surname = this.surname,
        pass = this.pass,
        disciplineId = this.disciplineId
    )
}