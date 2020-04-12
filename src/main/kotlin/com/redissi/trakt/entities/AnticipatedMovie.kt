package com.redissi.trakt.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class AnticipatedMovie(
    @Json(name = "list_count")
    val listCount: Int? = null,
    val movie: Movie? = null
)