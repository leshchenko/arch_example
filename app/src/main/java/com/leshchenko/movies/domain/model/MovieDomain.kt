package com.leshchenko.movies.domain.model

data class MovieDomain(
    val id: Int,
    val name: String?,
    val overview: String,
    val imageUrl: String?,
    val backgroundUrl: String,
    val averageRating: Float,
)