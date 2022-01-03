package com.leshchenko.movies.data.database.mapper

import com.leshchenko.movies.data.database.entities.MovieDetailsEntity
import com.leshchenko.movies.domain.model.MovieDetailsDomain

fun mapMovieDetailsEntityToDomain(movieDetailsEntity: MovieDetailsEntity) =
    with(movieDetailsEntity) {
        MovieDetailsDomain(movieId, adult, budget, originalLanguage, revenue, title, overview)
    }

fun mapMovieDetailsDomainToEntity(movieDetailsDomain: MovieDetailsDomain) =
    with(movieDetailsDomain) {
        MovieDetailsEntity(movieId, adult, budget, originalLanguage, revenue, title, overview)
    }