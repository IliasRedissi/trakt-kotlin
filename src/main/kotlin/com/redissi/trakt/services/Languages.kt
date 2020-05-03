package com.redissi.trakt.services

import com.redissi.trakt.entities.Language
import retrofit2.http.GET

interface Languages {
    /**
     * Get a list of all languages for movies, including names and codes.
     */
    @GET("languages/movies")
    suspend fun movies(): List<Language>?

    /**
     * Get a list of all languages for shows, including names and codes.
     */
    @GET("languages/shows")
    suspend fun shows(): List<Language>?
}