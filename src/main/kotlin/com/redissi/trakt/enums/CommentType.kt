package com.redissi.trakt.enums

enum class CommentType(private val value: String) : TraktEnum {
    ALL("all"),
    REVIEWS("reviews"),
    SHOUTS("shouts");

    override fun toString(): String {
        return value
    }
}