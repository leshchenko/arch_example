package com.leshchenko.movies.di

import com.leshchenko.movies.ui.movie_details.MovieDetailsViewModel
import com.leshchenko.movies.ui.movies_list.MoviesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MoviesListViewModel(get()) }
    viewModel { parameters -> MovieDetailsViewModel(get(), parameters[0]) }
}