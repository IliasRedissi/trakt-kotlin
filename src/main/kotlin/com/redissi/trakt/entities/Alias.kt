package com.redissi.trakt.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Alias(
    val title: String? = null,
    val country: String? = null
)