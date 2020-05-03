package com.redissi.trakt.enums

import java.util.*

enum class ReleaseType(val value: String) : TraktEnum {
    UNKNOWN("unknown"),
    PREMIERE("premiere"),
    LIMITED("limited"),
    THEATRICAL("theatrical"),
    DIGITAL("digital"),
    PHYSICAL("physical"),
    TV("tv");

    companion object {
        private val STRING_MAPPING: MutableMap<String, ReleaseType> =
            HashMap()

        fun fromValue(value: String): ReleaseType? {
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