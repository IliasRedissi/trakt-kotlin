package com.redissi.trakt.entities

import com.redissi.trakt.enums.ReleaseType
import com.squareup.moshi.JsonClass
import java.time.LocalDate

@JsonClass(generateAdapter = true)
class MovieRelease(
    val country: String? = null,
    val certification: String? = null,
    val releaseDate: LocalDate? = null,
    val releaseType: ReleaseType? = null,
    val note: String? = null
)