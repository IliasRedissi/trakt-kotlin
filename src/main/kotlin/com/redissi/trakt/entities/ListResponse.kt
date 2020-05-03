package com.redissi.trakt.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ListResponse(
    @Json(name = "like_count")
    val likeCount: Int? = null,
    @Json(name = "comment_count")
    val commentCount: Int? = null,
    val list: TraktList? = null
)