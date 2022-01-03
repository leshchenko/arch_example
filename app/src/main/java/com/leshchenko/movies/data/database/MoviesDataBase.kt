package com.leshchenko.movies.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leshchenko.movies.data.database.dao.MovieDetailsDao
import com.leshchenko.movies.data.database.dao.MoviesDao
import com.leshchenko.movies.data.database.entities.MovieDetailsEntity
import com.leshchenko.movies.data.database.entities.MovieEntity

@Database(entities = [MovieDetailsEntity::class, MovieEntity::class], version = 1)
abstract class MoviesDataBase : RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao
    abstract fun getMovieDetailsDao(): MovieDetailsDao
}