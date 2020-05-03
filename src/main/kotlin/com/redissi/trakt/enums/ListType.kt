package com.redissi.trakt.enums

import java.util.*
import kotlin.collections.HashMap

enum class ListType(val value: String) : TraktEnum {
    ALL("all"),
    PERSONAL("personal"),
    OFFICIAL("official"),
    WATCHLISTS("watchlists");

    companion object {
        private val STRING_MAPPING: MutableMap<String, ListType> = HashMap()

        fun fromValue(value: String): ListType? {
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
