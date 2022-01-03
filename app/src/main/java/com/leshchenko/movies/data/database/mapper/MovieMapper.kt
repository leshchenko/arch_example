package com.leshchenko.movies.data.database.mapper

import com.leshchenko.movies.data.database.entities.MovieEntity
import com.leshchenko.movies.domain.model.MovieDomain

fun mapMovieEntityToDomain(movieEntity: MovieEntity) = with(movieEntity) {
    MovieDomain(id, name, overview, imageUrl, backgroundUrl, averageRating)
}

fun mapMovieDomainToEntity(movieDomain: MovieDomain) = with(movieDomain) {
    MovieEntity(id, name, overview, imageUrl, backgroundUrl, averageRating)
}