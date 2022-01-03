package com.leshchenko.movies.di

import com.leshchenko.movies.data.api.MoviesApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(MoviesApi::class.java) }
}