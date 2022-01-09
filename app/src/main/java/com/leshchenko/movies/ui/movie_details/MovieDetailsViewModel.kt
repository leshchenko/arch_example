package com.leshchenko.movies.ui.movie_details

import com.leshchenko.movies.common.BaseViewModel
import com.leshchenko.movies.domain.repository.MoviesRepository
import com.leshchenko.movies.ui.movie_details.mapper.mapMovieDetailsToModelView
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

class MovieDetailsViewModel(
    private val moviesRepository: MoviesRepository,
    private val movieId: Int
) : BaseViewModel() {

    val movieDetailsFlow =
        moviesRepository.movieDetailsFlow(movieId).filterNotNull().map(::mapMovieDetailsToModelView)

    init {
        execute(request = {
            moviesRepository.loadMovieDetails(movieId)
        })
    }
}