package com.redissi.trakt.entities

import com.redissi.trakt.enums.Rating
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.OffsetDateTime

@JsonClass(generateAdapter = true)
class RatedEpisode(
    @Json(name = "rated_at")
    ratedAt: OffsetDateTime? = null,
    rating: Rating? = null,
    val episode: Episode? = null
) : RatedShow(ratedAt, rating)