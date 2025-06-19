package com.snick55.composemoviesapp.di

import com.snick55.composemoviesapp.data.ErrorHandler
import com.snick55.composemoviesapp.data.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindMoviesRepository(repository: MoviesRepository.Base): MoviesRepository

    @Binds
    abstract fun bindErrorHandler(errorHandler: ErrorHandler.BaseErrorHandler): ErrorHandler

}