package com.redissi.trakt.services

import com.redissi.trakt.entities.*
import com.redissi.trakt.enums.CommentSort
import com.redissi.trakt.enums.Extended
import com.redissi.trakt.enums.ListSort
import com.redissi.trakt.enums.ListType
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Seasons {
    /**
     * Returns all seasons for a show including the number of episodes in each season.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     */
    @GET("shows/{id}/seasons")
    suspend fun summary(
        @Path("id") showId: String,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<Season>?

    /**
     * Returns all episodes for a specific season of a show.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     * @param translations Include episode translations. Include all languages by setting the parameter to all
     * or use a specific 2 digit country language code to further limit it.
     */
    @GET("shows/{id}/seasons/{season}")
    suspend fun season(
        @Path("id") showId: String,
        @Path("season") season: Int,
        @Query("translations") translations: String? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<Episode>?

    /**
     * Returns all top level comments for a season. Most recent comments returned first.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/{id}/seasons/{season}/comments")
    suspend fun comments(
        @Path("id") showId: String,
        @Path("season") season: Int,
        @Path("sort") sort: CommentSort? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): List<Comment>?

    /**
     * Returns all lists that contain this season. By default, personal lists are returned sorted by the most popular.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     * @param type Filter for a specific list type.
     * @param sort How to sort.
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/{id}/seasons/{season}/lists/{type}/{sort}")
    suspend fun lists(
        @Path("id") showId: String,
        @Path("season") season: Int,
        @Path("type") type: ListType? = null,
        @Path("sort") sort: ListSort? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): List<TraktList>?

    /**
     * Returns all actors, directors, writers, and producers for a season.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     */
    @GET("shows/{id}/seasons/{season}/people")
    suspend fun people(
        @Path("id") showId: String,
        @Path("season") season: Int
    ): Credits?

    /**
     * Returns rating (between 0 and 10) and distribution for a season.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     */
    @GET("shows/{id}/seasons/{season}/ratings")
    suspend fun ratings(
        @Path("id") showId: String,
        @Path("season") season: Int
    ): Ratings?

    /**
     * Returns lots of season stats.
     */
    @GET("shows/{id}/seasons/{season}/stats")
    suspend fun stats(
        @Path("id") showId: String,
        @Path("season") season: Int
    ): Stats?

    /**
     * Returns all users watching this season right now.
     */
    @GET("shows/{id}/seasons/{season}/watching")
    suspend fun watching(
        @Path("id") showId: String,
        @Path("season") season: Int
    ): List<User>?
}