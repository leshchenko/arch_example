package com.leshchenko.movies.data.ext

import retrofit2.Response

fun <T> Response<T>.check(): Response<T> {
    if (!isSuccessful) {
        when (code()) {
            401 -> throw IllegalStateException("Unauthorized" + message())
            in 500..505 -> throw IllegalStateException("Server error" + message())
        }
    }
    return this
}