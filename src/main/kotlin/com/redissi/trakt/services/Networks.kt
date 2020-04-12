package com.redissi.trakt.services

import com.redissi.trakt.entities.Network
import retrofit2.http.GET

interface Networks {

    /**
     * Get a list of all TV networks, including the name.
     */
    @GET("networks")
    fun get(): List<Network>

}