package com.redissi.trakt.internal

import com.redissi.trakt.enums.Period
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

internal class PeriodAdapter {

    @ToJson
    fun toJson(period: Period): String {
        return period.toString()
    }

    @FromJson
    fun fromJson(period: String): Period? {
        return Period.fromValue(period)
    }

}