package com.leshchenko.movies.domain.repository

import com.leshchenko.movies.domain.model.MovieDetailsDomain
import com.leshchenko.movies.domain.model.MovieDomain
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun moviesFlow(): Flow<List<MovieDomain>>
    fun movieDetailsFlow(movieId: Int): Flow<MovieDetailsDomain?>
    suspend fun loadMovies(page: Int): List<MovieDomain>
    suspend fun loadMovieDetails(movieId: Int): MovieDetailsDomain?
}