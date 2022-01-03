package com.leshchenko.movies.data.repositories

import com.leshchenko.movies.data.datasource.MoviesDataSource
import com.leshchenko.movies.domain.model.MovieDetailsDomain
import com.leshchenko.movies.domain.model.MovieDomain
import com.leshchenko.movies.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class MoviesRepositoryImpl(
    private val moviesLocalDataSource: MoviesDataSource.Local,
    private val moviesRemoteDataSource: MoviesDataSource.Remote
) : MoviesRepository {
    override fun moviesFlow(): Flow<List<MovieDomain>> =
        moviesLocalDataSource.moviesFlow()

    override fun movieDetailsFlow(movieId: Int): Flow<MovieDetailsDomain?> =
        moviesLocalDataSource.movieDetailsFlow(movieId)

//    override suspend fun addMovies(movies: List<MovieDomain>) =
//        moviesLocalDataSource.addMovies(movies)
//
//    override suspend fun addMovieDetails(movieDetailsDomain: MovieDetailsDomain) =
//        moviesLocalDataSource.addMovieDetails(movieDetailsDomain)

    override suspend fun loadMovies(page: Int): List<MovieDomain> =
        moviesRemoteDataSource.loadMovies(page).also { movies ->
            moviesLocalDataSource.addMovies(movies)
        }

    override suspend fun loadMovieDetails(movieId: Int): MovieDetailsDomain? =
        moviesRemoteDataSource.loadMovieDetails(movieId)
            ?.also { movieDetails -> moviesLocalDataSource.addMovieDetails(movieDetails) }
}