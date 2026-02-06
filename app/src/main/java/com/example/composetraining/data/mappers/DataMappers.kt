package com.example.composetraining.data.mappers

import com.example.composetraining.data.local.DisciplineEntity
import com.example.composetraining.data.local.StudentEntity
import com.example.composetraining.data.local.TransactionsEntity
import com.example.composetraining.domain.models.Discipline
import com.example.composetraining.domain.models.Student
import com.example.composetraining.domain.models.Transaction

fun StudentEntity.toDomain() : Student {
    return Student(
        id = this.id,
        name = this.name,
        surname = this.surname,
        pass = this.pass
    )
}

fun Student.toEntity() : StudentEntity {
    return StudentEntity(
        id = this.id,
        name = this.name,
        surname = this.surname,
        pass = this.pass
    )
}

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
