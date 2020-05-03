package com.redissi.trakt.enums

import java.util.*
import kotlin.collections.HashMap

enum class ListSort(val value: String) : TraktEnum {
    POPULAR("popular"),
    LIKES("likes"),
    COMMENTS("comments"),
    ITEMS("items"),
    ADDED("added"),
    UPDATED("updated");

    companion object {
        private val STRING_MAPPING: MutableMap<String, ListSort> = HashMap()

        fun fromValue(value: String): ListSort? {
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
