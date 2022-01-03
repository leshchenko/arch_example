package com.leshchenko.movies.data.api

import com.leshchenko.movies.data.api.response.MoviesListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    @GET("trending/{media_type}/{time_window}")
    suspend fun getMoviesList(
        @Query("page") page: Int = 1,
        @Path("media_type") mediaType: String = "all",
        @Path("time_window") timeWindow: String = "week",
    ): Response<MoviesListResponse>
}