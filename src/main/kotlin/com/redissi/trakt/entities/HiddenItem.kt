package com.redissi.trakt.entities

import com.redissi.trakt.enums.Type
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.OffsetDateTime

@JsonClass(generateAdapter = true)
class HiddenItem(
    @Json(name = "hidden_at")
    val hiddenAt: OffsetDateTime? = null,
    val type: Type? = null,
    val show: Show? = null,
    val movie: Movie? = null,
    val season: Season? = null
)