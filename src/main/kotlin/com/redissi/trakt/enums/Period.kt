package com.redissi.trakt.enums

import java.util.*

enum class Period(val value: String) : TraktEnum {
    WEEKLY("weekly"),
    MONTHLY("monthly"),
    YEARLY("yearly"),
    ALL("all");

    companion object {
        private val STRING_MAPPING: MutableMap<String, Period> =
            HashMap()

        fun fromValue(value: String): Period? {
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