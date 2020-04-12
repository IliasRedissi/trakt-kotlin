package com.redissi.trakt.internal

import com.redissi.trakt.enums.CommentSort
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

internal class CommentSortAdapter {

    @ToJson
    fun toJson(commentSort: CommentSort): String {
        return commentSort.toString()
    }

    @FromJson
    fun fromJson(commentSort: String): CommentSort? {
        return CommentSort.fromValue(commentSort)
    }

}