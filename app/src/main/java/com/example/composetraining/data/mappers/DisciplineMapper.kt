package com.example.composetraining.data.mappers

import com.example.composetraining.data.local.DisciplineEntity
import com.example.composetraining.domain.models.Discipline

fun DisciplineEntity.toDomain() : Discipline {
    return Discipline(
        id = this.id,
        name = this.name
    )
}

fun Discipline.toEntity() : DisciplineEntity {
    return DisciplineEntity(
        id = this.id,
        name = this.name
    )
}