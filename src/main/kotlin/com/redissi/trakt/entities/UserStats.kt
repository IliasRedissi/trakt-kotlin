package com.redissi.trakt.entities

class UserStats(
    val movies: MoviesStats,
    val shows: ShowsStats,
    val seasons: SeasonsStats,
    val episodes: EpisodesStats,
    val ratings: RatingsStats
)

class MoviesStats(
    val plays: Int,
    val watched: Int,
    val minutes: Long,
    val collected: Int,
    val ratings: Int,
    val comments: Int
)

class ShowsStats(
    val watched: Int,
    val collected: Int,
    val ratings: Int,
    val comments: Int
)

class SeasonsStats(
    val ratings: Int,
    val comments: Int
)

class EpisodesStats(
    val plays: Int,
    val watched: Int,
    val minutes: Long,
    val collected: Int,
    val ratings: Int,
    val comments: Int
)

class NetworkStats(
    val friends: Int,
    val followers: Int,
    val following: Int
)

class RatingsStats(
    val total: Int,
    val distribution: Map<String, Int>? = null
)