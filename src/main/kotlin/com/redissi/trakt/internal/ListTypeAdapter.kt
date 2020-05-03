package com.redissi.trakt.internal

import com.redissi.trakt.enums.ListType
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

internal class ListTypeAdapter {

    @ToJson
    fun toJson(listType: ListType): String {
        return listType.toString()
    }

    @FromJson
    fun fromJson(listType: String): ListType? {
        return ListType.fromValue(listType)
    }

}