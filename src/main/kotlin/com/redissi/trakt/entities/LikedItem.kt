package com.redissi.trakt.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.OffsetDateTime

@JsonClass(generateAdapter = true)
class LikedItem(
    @Json(name = "liked_at")
    val likedAt: OffsetDateTime? = null,
    val type: String? = null,
    val comment: Comment? = null,
    val list: TraktList? = null
)