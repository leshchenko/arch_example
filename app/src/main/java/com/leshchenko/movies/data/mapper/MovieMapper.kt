package com.leshchenko.movies.data.mapper

import com.leshchenko.movies.data.api.response.MoviesListItem
import com.leshchenko.movies.domain.model.MovieDomain

fun mapMovieToDomain(movie: MoviesListItem) = with(movie) {
    MovieDomain(id, name, overview, imageURi, backgroundURi, averageRating)
}