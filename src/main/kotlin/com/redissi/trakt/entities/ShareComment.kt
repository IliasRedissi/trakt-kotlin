package com.redissi.trakt.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ShareComment(
    val twitter: Boolean? = null,
    val tumblr: Boolean? = null,
    val medium: Boolean? = null
)