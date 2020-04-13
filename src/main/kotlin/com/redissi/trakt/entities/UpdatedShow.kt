package com.redissi.trakt.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.OffsetDateTime

@JsonClass(generateAdapter = true)
class UpdatedShow(
    @Json(name = "updated_at")
    val updatedAt: OffsetDateTime? = null,
    val show: Show? = null
)