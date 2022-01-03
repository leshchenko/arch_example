package com.leshchenko.movies.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "movie")
data class MovieEntity(
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "overview")
    val overview: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String?,
    @ColumnInfo(name = "background_url")
    val backgroundUrl: String,
    @ColumnInfo(name = "average_rating")
    val averageRating: Float,
)