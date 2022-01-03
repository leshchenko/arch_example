package com.leshchenko.movies.domain.model

data class MovieDetailsDomain(
    val movieId: Int,
    val adult: Boolean,
    val budget: Int,
    val originalLanguage: String,
    val revenue: Int,
    val title: String,
    val overview: String,
)