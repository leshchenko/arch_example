package com.leshchenko.movies.ui.movies_list.mapper

import com.leshchenko.movies.domain.model.MovieDomain
import com.leshchenko.movies.ui.movies_list.model.MovieModelView

fun mapMovieDomainToModelView(movieDomain: MovieDomain) = with(movieDomain) {
    MovieModelView(movieDomain.id, movieDomain.name ?: "Unknown Name")
}