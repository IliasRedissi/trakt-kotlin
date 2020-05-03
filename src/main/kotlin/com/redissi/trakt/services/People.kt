package com.redissi.trakt.services

import com.redissi.trakt.entities.Credits
import com.redissi.trakt.entities.Person
import com.redissi.trakt.entities.TraktList
import com.redissi.trakt.enums.Extended
import com.redissi.trakt.enums.ListSort
import com.redissi.trakt.enums.ListType
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface People {
    /**
     * Returns a single person's details.
     *
     * @param personId trakt ID, trakt slug, or IMDB ID Example: bryan-cranston.
     */
    @GET("people/{id}")
    suspend fun summary(
        @Path("id") personId: String,
        @Query("extended") extended: Extended? = null
    ): Person?

    /**
     * Returns all movies where this person is in the cast or crew.
     *
     * @param personId trakt ID, trakt slug, or IMDB ID Example: bryan-cranston.
     */
    @GET("people/{id}/movies")
    suspend fun movieCredits(
        @Path("id") personId: String,
        @Query("extended") extended: Extended? = null
    ): Credits?

    /**
     * Returns all shows where this person is in the cast or crew, including the episode_count for which they appear.
     *
     * @param personId trakt ID, trakt slug, or IMDB ID Example: bryan-cranston.
     */
    @GET("people/{id}/shows")
    suspend fun showCredits(
        @Path("id") personId: String,
        @Query("extended") extended: Extended? = null
    ): Credits?

    /**
     * Returns all lists that contain this person. By default, personal lists are returned sorted by the most popular.
     *
     * @param personId trakt ID, trakt slug, or IMDB ID Example: bryan-cranston.
     * @param type Filter for a specific list type.
     * @param sort How to sort.
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("people/{id}/lists")
    suspend fun lists(
        @Path("id") personId: String,
        @Path("type") type: ListType? = null,
        @Path("sort") sort: ListSort? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): List<TraktList>?


}