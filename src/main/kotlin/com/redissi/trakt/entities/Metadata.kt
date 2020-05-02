package com.redissi.trakt.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Metadata(
    @Json(name = "media_type")
    val mediaType: String? = null,
    val resolution: String? = null,
    val hdr: String? = null,
    val audio: String? = null,
    @Json(name = "audio_channels")
    val audioChannels: String? = null,
    val `3d`: Boolean? = null
)