package com.example.composetraining.data.mappers

import com.example.composetraining.data.local.TransactionsEntity
import com.example.composetraining.domain.models.Transaction

fun TransactionsEntity.toDomain() : Transaction {
    return Transaction(
        id = this.id,
        student = this.studentId,
        discipline = this.disciplineId,
        point = this.point
    )
}

fun Transaction.toEntity() : TransactionsEntity {
    return TransactionsEntity(
        id = this.id,
        studentId = this.student,
        disciplineId = this.discipline,
        point = this.point
    )
}
