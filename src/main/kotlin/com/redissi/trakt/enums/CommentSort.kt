package com.redissi.trakt.enums

import java.util.*

enum class CommentSort(val value: String) : TraktEnum {
    NEWEST("newest"),
    OLDEST("oldest"),
    LIKES("likes"),
    REPLIES("replies"),
    HIGHEST("highest"),
    LOWEST("lowest"),
    PLAYS("plays");

    companion object {
        private val STRING_MAPPING: MutableMap<String, CommentSort> = HashMap()

        fun fromValue(value: String): CommentSort? {
            return STRING_MAPPING[value.toUpperCase(Locale.ROOT)]
        }

        init {
            for (value in values()) {
                STRING_MAPPING[value.toString().toUpperCase(Locale.ROOT)] = value
            }
        }
    }

    override fun toString(): String {
        return value
    }
}
