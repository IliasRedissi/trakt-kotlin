package com.redissi.trakt.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.OffsetDateTime

@JsonClass(generateAdapter = true)
class BaseShow(
    val show: Show? = null,
    /** collection, watched  */
    val seasons: List<BaseSeason>? = null,
    /** collection  */
    @Json(name = "last_collected_at")
    val lastCollectedAt: OffsetDateTime? = null,
    /** watchlist  */
    @Json(name = "listed_at")
    val listedAt: OffsetDateTime? = null,
    /** watched  */
    val plays: Int? = null,
    @Json(name = "last_watched_at")
    val lastWatchedAt: OffsetDateTime? = null,
    @Json(name = "last_updated_at")
    val lastUpdatedAt: OffsetDateTime? = null,
    @Json(name = "reset_at")
    val resetAt: OffsetDateTime? = null,
    /** progress  */
    val aired: Int? = null,
    val completed: Int? = null,
    @Json(name = "hidden_seasons")
    val hiddenSeasons: List<Season>? = null,
    @Json(name = "next_episode")
    val nextEpisode: Episode? = null
)