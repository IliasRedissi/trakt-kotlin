package com.redissi.trakt.services

import com.redissi.trakt.entities.ListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Lists {

    /**
     *  Returns all lists with the most likes and comments over the last 7 days.
     */
    @GET("lists/trending")
    suspend fun trending(
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): List<ListResponse>?

    /**
     *  Returns the most popular lists. Popularity is calculated using total number of likes and comments.
     */
    @GET("lists/popular")
    suspend fun popular(
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): List<ListResponse>?

}