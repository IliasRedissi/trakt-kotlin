package com.redissi.trakt.enums

enum class Types(private val value: String) : TraktEnum {
    MOVIES("movies"),
    SHOWS("shows"),
    SEASONS("seasons"),
    EPISODES("episodes"),
    PERSONS("persons"),
    LISTS("lists");

    override fun toString(): String {
        return value
    }

}