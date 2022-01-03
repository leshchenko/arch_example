package com.leshchenko.movies.data.database.datasource

import com.leshchenko.movies.data.database.dao.MovieDetailsDao
import com.leshchenko.movies.data.database.dao.MoviesDao
import com.leshchenko.movies.data.database.mapper.mapMovieDetailsDomainToEntity
import com.leshchenko.movies.data.database.mapper.mapMovieDetailsEntityToDomain
import com.leshchenko.movies.data.database.mapper.mapMovieDomainToEntity
import com.leshchenko.movies.data.database.mapper.mapMovieEntityToDomain
import com.leshchenko.movies.data.datasource.MoviesDataSource
import com.leshchenko.movies.domain.model.MovieDetailsDomain
import com.leshchenko.movies.domain.model.MovieDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MoviesLocalDataSourceImpl(
    private val moviesDao: MoviesDao,
    private val movieDetailsDao: MovieDetailsDao
) : MoviesDataSource.Local {
    override fun moviesFlow(): Flow<List<MovieDomain>> =
        moviesDao.fetchMovies().map { moviesList -> moviesList.map(::mapMovieEntityToDomain) }

    override fun movieDetailsFlow(movieId: Int): Flow<MovieDetailsDomain?> =
        movieDetailsDao.fetchMovieDetails(movieId)
            .map { movieDetails -> movieDetails?.let(::mapMovieDetailsEntityToDomain) }

    override suspend fun addMovies(movies: List<MovieDomain>) =
        moviesDao.addMovies(movies.map(::mapMovieDomainToEntity))

    override suspend fun addMovieDetails(movieDetailsDomain: MovieDetailsDomain) =
        movieDetailsDao.addMovieDetails(mapMovieDetailsDomainToEntity(movieDetailsDomain))

}