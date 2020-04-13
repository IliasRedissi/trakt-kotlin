package com.redissi.trakt.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MostShow(
    @Json(name = "watcher_count")
    val watcherCount: Int? = null,
    @Json(name = "play_count")
    val playCount: Int? = null,
    @Json(name = "collected_count")
    val collectedCount: Int? = null,
    @Json(name = "collector_count")
    val collectorCount: Int? = null,
    val show: Show? = null
)