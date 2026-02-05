package com.example.composetraining.di

import com.example.composetraining.data.local.MyDao
import com.example.composetraining.data.local.MyDatabase
import com.example.composetraining.data.repository.DatabaseRepositoryImpl
import com.example.composetraining.domain.repository.DatabaseRepository
import com.example.composetraining.domain.usecases.AddStudentUseCase
import com.example.composetraining.domain.usecases.GetAllStudentsUseCase
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
}