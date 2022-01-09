package com.leshchenko.movies.ui.movie_details.mapper

import com.leshchenko.movies.domain.model.MovieDetailsDomain
import com.leshchenko.movies.ui.movie_details.model.MovieDetailsModelView

fun mapMovieDetailsToModelView(movieDetailsDomain: MovieDetailsDomain) = with(movieDetailsDomain) {
    MovieDetailsModelView(adult, budget, originalLanguage, title)
}