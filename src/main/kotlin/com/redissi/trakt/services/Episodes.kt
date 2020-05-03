package com.redissi.trakt.services

import com.redissi.trakt.entities.*
import com.redissi.trakt.enums.Extended
import com.redissi.trakt.enums.ListSort
import com.redissi.trakt.enums.ListType
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Episodes {
    /**
     * Returns a single episode's details.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     * @param episode Episode number.
     */
    @GET("shows/{id}/seasons/{season}/episodes/{episode}")
    suspend fun summary(
        @Path("id") showId: String,
        @Path("season") season: Int,
        @Path("episode") episode: Int,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): Episode?

    /**
     * Returns all translations for an episode, including language and translated values for title and overview.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     * @param episode Episode number.
     */
    @GET("shows/{id}/seasons/{season}/episodes/{episode}/translations")
    suspend fun translations(
        @Path("id") showId: String,
        @Path("season") season: Int,
        @Path("episode") episode: Int
    ): List<Translation>?
    /**
     * Returns all translations for an episode, including language and translated values for title and overview.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     * @param episode Episode number.
     * @param language 2 character language code.
     */
    @GET("shows/{id}/seasons/{season}/episodes/{episode}/translations/{language}")
    suspend fun translations(
        @Path("id") showId: String,
        @Path("season") season: Int,
        @Path("episode") episode: Int,
        @Path("language") language: String
    ): List<Translation>?

    /**
     * Returns all top level comments for an episode. Most recent comments returned first.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     * @param episode Episode number.
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/{id}/seasons/{season}/episodes/{episode}/comments")
    suspend fun comments(
        @Path("id") showId: String,
        @Path("season") season: Int,
        @Path("episode") episode: Int,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<Comment?>?

    /**
     * Returns all lists that contain this episode. By default, personal lists are returned sorted by the most popular.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     * @param episode Episode number.
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/{id}/seasons/{season}/episodes/{episode}/lists")
    suspend fun lists(
        @Path("id") showId: String,
        @Path("season") season: Int,
        @Path("episode") episode: Int,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): List<TraktList>?

    /**
     * Returns all lists that contain this episode. By default, personal lists are returned sorted by the most popular.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     * @param episode Episode number.
     * @param type Filter for a specific list type.
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/{id}/seasons/{season}/episodes/{episode}/lists/{type}")
    suspend fun lists(
        @Path("id") showId: String,
        @Path("season") season: Int,
        @Path("episode") episode: Int,
        @Path("type") type: ListType,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): List<TraktList>?

    /**
     * Returns all lists that contain this episode. By default, personal lists are returned sorted by the most popular.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     * @param episode Episode number.
     * @param type Filter for a specific list type.
     * @param sort How to sort.
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/{id}/seasons/{season}/episodes/{episode}/lists/{type}/{sort}")
    suspend fun lists(
        @Path("id") showId: String,
        @Path("season") season: Int,
        @Path("episode") episode: Int,
        @Path("type") type: ListType,
        @Path("sort") sort: ListSort,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): List<TraktList>?

    /**
     * Returns all actors, directors, writers, and producers for an episode.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     * @param episode Episode number.
     */
    @GET("shows/{id}/seasons/{season}/episodes/{episode}/people")
    suspend fun people(
        @Path("id") showId: String,
        @Path("season") season: Int,
        @Path("episode") episode: Int
    ): Credits?

    /**
     * Returns rating (between 0 and 10) and distribution for an episode.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     * @param episode Episode number.
     */
    @GET("shows/{id}/seasons/{season}/episodes/{episode}/ratings")
    suspend fun ratings(
        @Path("id") showId: String,
        @Path("season") season: Int,
        @Path("episode") episode: Int
    ): Ratings?

    /**
     * Returns lots of episode stats.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     * @param episode Episode number.
     */
    @GET("shows/{id}/seasons/{season}/episodes/{episode}/stats")
    suspend fun stats(
        @Path("id") showId: String,
        @Path("season") season: Int,
        @Path("episode") episode: Int
    ): Stats?

    /**
     * Returns all users watching this episode right now.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param season Season number.
     * @param episode Episode number.
     */
    @GET("shows/{id}/seasons/{season}/episodes/{episode}/watching")
    suspend fun watching(
        @Path("id") showId: String,
        @Path("season") season: Int,
        @Path("episode") episode: Int,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): Stats?
}