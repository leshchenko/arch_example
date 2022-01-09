package com.leshchenko.movies.ui.movie_details.model

data class MovieDetailsModelView(
    val adult: Boolean,
    val budget: Int,
    val originalLanguage: String,
    val title: String
)