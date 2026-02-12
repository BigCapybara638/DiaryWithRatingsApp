package com.example.composetraining.di

import com.example.composetraining.data.local.MyDao
import com.example.composetraining.data.local.MyDatabase
import com.example.composetraining.data.repository.DatabaseRepositoryImpl
import com.example.composetraining.domain.repository.DatabaseRepository
import com.example.composetraining.domain.usecases.add.AddDisciplineUseCase
import com.example.composetraining.domain.usecases.add.AddMarkUseCase
import com.example.composetraining.domain.usecases.add.AddStudentUseCase
import com.example.composetraining.domain.usecases.ChangePassForStudentUseCase
import com.example.composetraining.domain.usecases.getAll.GetAllDisciplinesUseCase
import com.example.composetraining.domain.usecases.getAll.GetAllStudentsUseCase
import com.example.composetraining.domain.usecases.getAll.GetAllTeachersUseCase
import com.example.composetraining.domain.usecases.GetMarksForStudentUseCase
import com.example.composetraining.domain.usecases.GetStudentByIdUseCase
import com.example.composetraining.domain.usecases.GetVerificationUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn (ViewModelComponent::class)
object AppModule {

    @Provides
    @ViewModelScoped
    fun provideMyDao(database: MyDatabase): MyDao {
        return database.myDao()
    }

    @Provides
    @ViewModelScoped
    fun provideDatabaseRepository(
        dao: MyDao
    ) : DatabaseRepository {
        return DatabaseRepositoryImpl(dao)
    }

    @Provides
    @ViewModelScoped
    fun provideAddStudentUseCase(
        repository: DatabaseRepository
    ) : AddStudentUseCase {
        return AddStudentUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideAddDisciplineUseCase(
        repository: DatabaseRepository
    ) : AddDisciplineUseCase {
        return AddDisciplineUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetAllStudentsUseCase(
        repository: DatabaseRepository
    ) : GetAllStudentsUseCase {
        return GetAllStudentsUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetAllDisciplinesUseCase(
        repository: DatabaseRepository
    ) : GetAllDisciplinesUseCase {
        return GetAllDisciplinesUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetAllTeachersUseCase(
        repository: DatabaseRepository
    ) : GetAllTeachersUseCase {
        return GetAllTeachersUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetStudentByIdUseCase(
        repository: DatabaseRepository
    ) : GetStudentByIdUseCase {
        return GetStudentByIdUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideAddMarkUseCase(
        repository: DatabaseRepository
    ) : AddMarkUseCase {
        return AddMarkUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetMarksForStudentUseCase(
        repository: DatabaseRepository
    ) : GetMarksForStudentUseCase {
        return GetMarksForStudentUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetVerificationUserUseCase(
        repository: DatabaseRepository
    ) : GetVerificationUserUseCase {
        return GetVerificationUserUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideChangePassForStudentUseCase(
        repository: DatabaseRepository
    ) : ChangePassForStudentUseCase {
        return ChangePassForStudentUseCase(repository)
    }

}