package com.redissi.trakt.services

import com.redissi.trakt.entities.Country
import retrofit2.http.GET

interface Countries {

    /**
     *  Get a list of all countries for movies, including names and codes.
     */
    @GET("countries/movies")
    suspend fun movies(): List<Country>?

    /**
     *  Get a list of all countries for movies, including names and codes.
     */
    @GET("countries/shows")
    suspend fun shows(): List<Country>?

}