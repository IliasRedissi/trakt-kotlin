package com.redissi.trakt.entities

import com.squareup.moshi.Json
import java.time.OffsetDateTime

class BaseMovie(
    val movie: Movie? = null,
    @Json(name = "collected_at")
    val collectedAt: OffsetDateTime? = null,
    @Json(name = "last_watched_at")
    val lastWatchedAt: OffsetDateTime? = null,
    @Json(name = "last_updated_at")
    val lastUpdatedAt: OffsetDateTime? = null,
    @Json(name = "listed_at")
    val listedAt: OffsetDateTime? = null,
    val plays: Int = 0
)