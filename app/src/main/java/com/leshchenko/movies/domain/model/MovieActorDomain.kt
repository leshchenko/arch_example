package com.leshchenko.movies.domain.model

data class MovieActorDomain(
    val id: Int = 0,
    val name: String,
    val character: String,
    val photoUrl: String?
)
