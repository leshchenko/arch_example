package com.leshchenko.movies.di

import com.leshchenko.movies.data.repositories.MoviesRepositoryImpl
import com.leshchenko.movies.domain.repository.MoviesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MoviesRepository> { MoviesRepositoryImpl(get(), get()) }
}