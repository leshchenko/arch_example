package com.leshchenko.movies.data.api.response

import com.google.gson.annotations.SerializedName

data class MovieDetailsResponse(
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("revenue")
    val revenue: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
)