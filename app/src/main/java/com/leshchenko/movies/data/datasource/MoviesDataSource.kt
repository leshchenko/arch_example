package com.leshchenko.movies.data.datasource

import com.leshchenko.movies.domain.model.MovieDetailsDomain
import com.leshchenko.movies.domain.model.MovieDomain
import kotlinx.coroutines.flow.Flow

interface MoviesDataSource {
    interface Local {
        fun moviesFlow(): Flow<List<MovieDomain>>
        fun movieDetailsFlow(movieId: Int): Flow<MovieDetailsDomain?>
        suspend fun addMovies(movies: List<MovieDomain>)
        suspend fun addMovieDetails(movieDetailsDomain: MovieDetailsDomain)
    }

    interface Remote {
        suspend fun loadMovies(page: Int): List<MovieDomain>
        suspend fun loadMovieDetails(movieId: Int): MovieDetailsDomain?
    }
}