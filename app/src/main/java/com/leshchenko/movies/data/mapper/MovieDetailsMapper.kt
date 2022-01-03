package com.leshchenko.movies.data.mapper

import com.leshchenko.movies.data.api.response.MovieDetailsResponse
import com.leshchenko.movies.domain.model.MovieDetailsDomain

fun mapMovieDetailsToDomain(movieDetails: MovieDetailsResponse) = with(movieDetails) {
    MovieDetailsDomain(movieId, adult, budget, originalLanguage, revenue, title, overview)
}
