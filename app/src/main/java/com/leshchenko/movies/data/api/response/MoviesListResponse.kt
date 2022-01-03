package com.leshchenko.movies.data.api.response

import com.google.gson.annotations.SerializedName

data class MoviesListResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MoviesListItem>,
    @SerializedName("total_pages")
    val totalPages: Int,
)

data class MoviesListItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val imageURi: String?,
    @SerializedName("backdrop_path")
    val backgroundURi: String,
    @SerializedName("vote_average")
    val averageRating: Float,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("media_type")
    val mediaType: String
)