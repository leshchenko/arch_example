package com.leshchenko.movies.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.leshchenko.movies.data.database.entities.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class MoviesDao {
    @Query("SELECT * FROM movie")
    abstract fun fetchMovies(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addMovies(movies: List<MovieEntity>)
}