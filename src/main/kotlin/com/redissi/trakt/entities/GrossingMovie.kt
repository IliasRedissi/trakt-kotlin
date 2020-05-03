package com.redissi.trakt.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class GrossingMovie(
    val revenue: Int? = null,
    val movie: Movie? = null
)