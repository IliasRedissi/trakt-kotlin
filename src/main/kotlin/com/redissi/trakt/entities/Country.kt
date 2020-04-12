package com.redissi.trakt.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Country(
    val name: String,
    val code: String
)