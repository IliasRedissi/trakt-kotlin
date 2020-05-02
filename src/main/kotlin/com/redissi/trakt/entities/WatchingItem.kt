package com.redissi.trakt.entities

import java.time.OffsetDateTime

class WatchingItem(
    val expiresAt: OffsetDateTime? = null,
    val startedAt: OffsetDateTime? = null,
    val action: String? = null,
    val type: String? = null,
    val episode: Episode? = null,
    val show: Show? = null,
    val movie: Movie? = null
)