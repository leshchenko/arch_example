package com.leshchenko.movies.di

import com.leshchenko.movies.data.api.datasource.MoviesRemoteDataSourceImpl
import com.leshchenko.movies.data.database.datasource.MoviesLocalDataSourceImpl
import com.leshchenko.movies.data.datasource.MoviesDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<MoviesDataSource.Local> { MoviesLocalDataSourceImpl(get(), get()) }
    single<MoviesDataSource.Remote> { MoviesRemoteDataSourceImpl(get(), get()) }
}