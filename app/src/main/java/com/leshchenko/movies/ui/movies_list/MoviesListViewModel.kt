package com.leshchenko.movies.ui.movies_list

import com.leshchenko.movies.common.BaseViewModel
import com.leshchenko.movies.domain.repository.MoviesRepository

class MoviesListViewModel(private val moviesRepository: MoviesRepository) : BaseViewModel() {
    val moviesList = moviesRepository.moviesFlow()

    init {
        execute(request = { moviesRepository.loadMovies(1) })
    }
}