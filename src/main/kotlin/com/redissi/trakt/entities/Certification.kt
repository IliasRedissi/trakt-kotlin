package com.redissi.trakt.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Certification(
    val name: String? = null,
    val slug: String? = null,
    val description: String? = null
)