package com.redissi.trakt.entities

import com.redissi.trakt.enums.Rating
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.OffsetDateTime

@JsonClass(generateAdapter = true)
open class BaseRatedEntity(
    @Json(name = "rated_at")
    val ratedAt: OffsetDateTime? = null,
    val rating: Rating? = null
)