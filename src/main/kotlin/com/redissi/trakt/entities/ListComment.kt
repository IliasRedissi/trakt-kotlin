package com.redissi.trakt.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ListComment(
    val type: String? = null,
    val movie: Movie? = null,
    val show: Show? = null,
    val season: Season? = null,
    val episode: Episode? = null,
    val comment: Comment? = null
)