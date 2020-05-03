package com.redissi.trakt.internal

import com.redissi.trakt.enums.ListSort
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

internal class ListSortAdapter {

    @ToJson
    fun toJson(listSort: ListSort): String {
        return listSort.toString()
    }

    @FromJson
    fun fromJson(listSort: String): ListSort? {
        return ListSort.fromValue(listSort)
    }

}