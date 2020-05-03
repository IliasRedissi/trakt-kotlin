package com.redissi.trakt.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.OffsetDateTime

@JsonClass(generateAdapter = true)
class ListLike(
    @Json(name = "liked_at")
    val likedAt: OffsetDateTime,
    val user: User
)