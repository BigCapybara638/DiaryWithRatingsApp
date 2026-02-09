package com.example.composetraining.data.mappers

import com.example.composetraining.data.local.StudentEntity
import com.example.composetraining.domain.models.Student

fun StudentEntity.toDomain() : Student {
    return Student(
        id = this.id,
        name = this.name,
        surname = this.surname,
        pass = this.pass,
        lastUpdatePass = this.lastUpdatePass
    )
}

fun Student.toEntity() : StudentEntity {
    return StudentEntity(
        id = this.id,
        name = this.name,
        surname = this.surname,
        pass = this.pass,
        lastUpdatePass = this.lastUpdatePass
    )
}