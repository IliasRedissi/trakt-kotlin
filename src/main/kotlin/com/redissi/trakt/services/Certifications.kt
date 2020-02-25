package com.redissi.trakt.services

import com.redissi.trakt.entities.Certification
import retrofit2.http.GET

interface Certifications {

    /**
     * Get a list of all certifications for movies, including names and slugs.
     */
    @GET("certifications/movies")
    suspend fun movies(): Map<String, List<Certification>>?

    /**
     * Get a list of all certifications for shows, including names and slugs.
     */
    @GET("certifications/shows")
    suspend fun shows(): Map<String, List<Certification>>?

}