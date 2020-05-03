package com.redissi.trakt.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.OffsetDateTime

@JsonClass(generateAdapter = true)
class FollowRequest(
    val id: Int? = null,
    @Json(name = "requested_at")
    val requestedAt: OffsetDateTime? = null,
    val user: User? = null
)