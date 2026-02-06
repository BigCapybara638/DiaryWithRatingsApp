package com.example.composetraining.di

import com.example.composetraining.data.local.MyDao
import com.example.composetraining.data.local.MyDatabase
import com.example.composetraining.data.repository.DatabaseRepositoryImpl
import com.example.composetraining.domain.repository.DatabaseRepository
import com.example.composetraining.domain.usecases.AddDisciplineUseCase
import com.example.composetraining.domain.usecases.AddMarkUseCase
import com.example.composetraining.domain.usecases.AddStudentUseCase
import com.example.composetraining.domain.usecases.GetAllStudentsUseCase
import com.example.composetraining.domain.usecases.GetMarksForStudentUseCase
import com.example.composetraining.domain.usecases.GetStudentByIdUseCase
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
    fun provideGetAllStudentsUseCase(
        repository: DatabaseRepository
    ) : GetAllStudentsUseCase {
        return GetAllStudentsUseCase(repository)
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

}