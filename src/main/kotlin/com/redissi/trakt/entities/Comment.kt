package com.redissi.trakt.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.OffsetDateTime

@JsonClass(generateAdapter = true)
class Comment(
    val id: Int? = null,
    @Json(name = "parent_id")
    val parentId: Int? = null,
    @Json(name = "created_at")
    val createdAt: OffsetDateTime? = null,
    @Json(name = "updated_at")
    val updatedAt: OffsetDateTime? = null,
    val comment: String? = null,
    val spoiler: Boolean? = null,
    val review: Boolean? = null,
    val replies: Int? = null,
    val likes: Int? = null,
    @Json(name = "user_rating")
    val userRating: Int? = null,
    val user: User? = null,
    // for posting
    val movie: Movie? = null,
    val show: Show? = null,
    val season: Season? = null,
    val episode: Episode? = null,
    val list: TraktList? = null,
    val sharing: ShareComment? = null
) {

    companion object {
        /**
         * Build a movie comment.
         */
        fun build(movie: Movie, comment: String, spoiler: Boolean, review: Boolean, sharing: ShareComment? = null) =
            Comment(comment = comment, spoiler = spoiler, review = review, movie = movie, sharing = sharing)

        /**
         * Build a show comment.
         */
        fun build(show: Show, comment: String, spoiler: Boolean, review: Boolean, sharing: ShareComment? = null) =
            Comment(comment = comment, spoiler = spoiler, review = review, show = show, sharing = sharing)

        /**
         * Build a season comment.
         */
        fun build(season: Season, comment: String, spoiler: Boolean, review: Boolean, sharing: ShareComment? = null) =
            Comment(comment = comment, spoiler = spoiler, review = review, season = season, sharing = sharing)

        /**
         * Build an episode comment.
         */
        fun build(episode: Episode, comment: String, spoiler: Boolean, review: Boolean, sharing: ShareComment? = null) =
            Comment(comment = comment, spoiler = spoiler, review = review, episode = episode, sharing = sharing)

        /**
         * Build a list comment.
         */
        fun build(list: TraktList, comment: String, spoiler: Boolean, review: Boolean, sharing: ShareComment? = null) =
            Comment(comment = comment, spoiler = spoiler, review = review, list = list, sharing = sharing)

        /**
         * Build an updated/reply comment.
         */
        fun build(comment: String, spoiler: Boolean, review: Boolean) =
            Comment(comment = comment, spoiler = spoiler, review = review)
    }

}