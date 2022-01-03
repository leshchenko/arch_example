package com.leshchenko.movies.di

import androidx.room.Room
import com.leshchenko.movies.data.database.MoviesDataBase
import org.koin.dsl.module


private const val DB_NAME = "Movies.db"

val dbModule = module {

    single {
        Room.databaseBuilder(get(), MoviesDataBase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    factory { get<MoviesDataBase>().getMovieDetailsDao() }
    factory { get<MoviesDataBase>().getMoviesDao() }
}