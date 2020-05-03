package com.redissi.trakt.internal

import com.redissi.trakt.enums.ReleaseType
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

internal class ReleaseTypeAdapter {

    @ToJson
    fun toJson(releaseType: ReleaseType): String {
        return releaseType.toString()
    }

    @FromJson
    fun fromJson(releaseType: String): ReleaseType? {
        return ReleaseType.fromValue(releaseType)
    }

}