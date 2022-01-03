package com.leshchenko.movies.data.api.datasource

import com.leshchenko.movies.data.api.MovieDetailsApi
import com.leshchenko.movies.data.api.MoviesApi
import com.leshchenko.movies.data.datasource.MoviesDataSource
import com.leshchenko.movies.data.ext.check
import com.leshchenko.movies.data.mapper.mapMovieDetailsToDomain
import com.leshchenko.movies.data.mapper.mapMovieToDomain
import com.leshchenko.movies.domain.model.MovieDetailsDomain
import com.leshchenko.movies.domain.model.MovieDomain

class MoviesRemoteDataSourceImpl(
    private val moviesApi: MoviesApi,
    private val movieDetailsApi: MovieDetailsApi
) : MoviesDataSource.Remote {

    override suspend fun loadMovies(page: Int): List<MovieDomain> =
        moviesApi.getMoviesList(page).check().body()?.results?.map(::mapMovieToDomain)
            ?: emptyList()

    override suspend fun loadMovieDetails(movieId: Int): MovieDetailsDomain? =
        movieDetailsApi.getMovieDetails(movieId).check().body()?.let(::mapMovieDetailsToDomain)
}