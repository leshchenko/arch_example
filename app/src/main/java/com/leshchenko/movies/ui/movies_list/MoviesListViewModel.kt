package com.leshchenko.movies.ui.movies_list

import android.util.Log
import com.leshchenko.movies.common.BaseViewModel
import com.leshchenko.movies.domain.repository.MoviesRepository
import com.leshchenko.movies.ui.movies_list.mapper.mapMovieDomainToModelView
import kotlinx.coroutines.flow.map

class MoviesListViewModel(private val moviesRepository: MoviesRepository) : BaseViewModel() {
    val moviesList = moviesRepository.moviesFlow()
        .map { moviesList -> moviesList.map(::mapMovieDomainToModelView) }

    init {
        execute(request = { moviesRepository.loadMovies(1) })
    }

    override fun showError(error: Throwable?) {
        Log.d("MoviesListViewModel", "showError: $error")
    }
}