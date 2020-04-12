package com.redissi.trakt.services

import com.redissi.trakt.entities.*
import com.redissi.trakt.enums.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.LocalDate

interface Movies {
    /**
     * Returns the most popular movies. Popularity is calculated using the rating percentage and the number of ratings.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("movies/popular")
    suspend fun popular(
        @Query("query") query: String? = null,
        @Query("years") years: String? = null,
        @Query("genres") genres: String? = null,
        @Query("languages") languages: String? = null,
        @Query("countries") countries: String? = null,
        @Query("runtimes") runtimes: String? = null,
        @Query("ratings") ratings: String? = null,
        @Query("certifications") certifications: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<Movie>?

    /**
     * Returns all movies being watched right now. Movies with the most users are returned first.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("movies/trending")
    suspend fun trending(
        @Query("query") query: String? = null,
        @Query("years") years: String? = null,
        @Query("genres") genres: String? = null,
        @Query("languages") languages: String? = null,
        @Query("countries") countries: String? = null,
        @Query("runtimes") runtimes: String? = null,
        @Query("ratings") ratings: String? = null,
        @Query("certifications") certifications: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<TrendingMovie>?

    /**
     * Returns the most played (a single user can watch multiple times) movies in the specified time `period`,
     * defaulting to `weekly`. All stats are relative to the specific time period.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("movies/played")
    suspend fun mostPlayed(
        @Query("period") period: Period? = null,
        @Query("query") query: String? = null,
        @Query("years") years: String? = null,
        @Query("genres") genres: String? = null,
        @Query("languages") languages: String? = null,
        @Query("countries") countries: String? = null,
        @Query("runtimes") runtimes: String? = null,
        @Query("ratings") ratings: String? = null,
        @Query("certifications") certifications: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<MostMovie>?

    /**
     * Returns the most watched (unique users) movies in the specified time period, defaulting to weekly.
     * All stats are relative to the specific time period.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("movies/watched")
    suspend fun mostWatched(
        @Query("period") period: Period? = null,
        @Query("query") query: String? = null,
        @Query("years") years: String? = null,
        @Query("genres") genres: String? = null,
        @Query("languages") languages: String? = null,
        @Query("countries") countries: String? = null,
        @Query("runtimes") runtimes: String? = null,
        @Query("ratings") ratings: String? = null,
        @Query("certifications") certifications: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<MostMovie>?

    /**
     * Returns the most collected (unique users) movies in the specified time period, defaulting to weekly.
     * All stats are relative to the specific time period.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("movies/collected")
    suspend fun mostCollected(
        @Query("period") period: Period? = null,
        @Query("query") query: String? = null,
        @Query("years") years: String? = null,
        @Query("genres") genres: String? = null,
        @Query("languages") languages: String? = null,
        @Query("countries") countries: String? = null,
        @Query("runtimes") runtimes: String? = null,
        @Query("ratings") ratings: String? = null,
        @Query("certifications") certifications: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<MostMovie>?

    /**
     * Returns the most anticipated movies based on the number of lists a movie appears on.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("movies/anticipated")
    suspend fun anticipated(
        @Query("query") query: String? = null,
        @Query("years") years: String? = null,
        @Query("genres") genres: String? = null,
        @Query("languages") languages: String? = null,
        @Query("countries") countries: String? = null,
        @Query("runtimes") runtimes: String? = null,
        @Query("ratings") ratings: String? = null,
        @Query("certifications") certifications: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<AnticipatedMovie>?

    /**
     * Returns the top 10 grossing movies in the U.S. box office last weekend. Updated every Monday morning.
     */
    @GET("movies/boxoffice")
    suspend fun weekendBoxOffice(
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<GrossingMovie>?

    /**
     * Returns all movies updated since the specified UTC date.
     * We recommended storing the date you can be efficient using this method moving forward.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("movies/updates")
    suspend fun recentlyUpdated(
        @Query("start_date") startDate: LocalDate? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<UpdatedMovie>?

    /**
     * Returns a single movie's details.
     *
     * @param movieId trakt ID, trakt slug, or IMDB ID. Example: "tron-legacy-2010".
     */
    @GET("movies/{id}")
    suspend fun summary(
        @Path("id") movieId: String,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): Movie?

    /**
     * Returns all title aliases for a movie. Includes country where name is different.
     *
     * @param movieId trakt ID, trakt slug, or IMDB ID. Example: "tron-legacy-2010".
     */
    @GET("movies/{id}/aliases")
    suspend fun aliases(
        @Path("id") movieId: String
    ): List<Alias>?

    /**
     * Returns all releases for a movie including country, certification, release date, release type, and note.
     *
     * @param movieId trakt ID, trakt slug, or IMDB ID. Example: "tron-legacy-2010".
     * @param country 2 character country code
     */
    @GET("movies/{id}/releases/{country}")
    suspend fun releases(
        @Path("id") movieId: String,
        @Path("country") country: String? = null
    ): List<MovieRelease>?

    /**
     * Returns all translations for a movie, including language and translated values for title, tagline and overview.
     *
     * @param movieId trakt ID, trakt slug, or IMDB ID. Example: "tron-legacy-2010".
     */
    @GET("movies/{id}/translations")
    suspend fun translations(
        @Path("id") movieId: String
    ): List<MovieTranslation>?

    /**
     * Returns a single translation for a movie. If the translation does not exist, the returned list will be empty.
     *
     * @param movieId trakt ID, trakt slug, or IMDB ID. Example: "tron-legacy-2010".
     * @param language 2-letter language code (ISO 639-1).
     */
    @GET("movies/{id}/translations/{language}")
    suspend fun translation(
        @Path("id") movieId: String,
        @Path("language") language: String
    ): List<MovieTranslation>?

    /**
     * Returns all top level comments for a movie. Most recent comments returned first.
     *
     * @param movieId trakt ID, trakt slug, or IMDB ID. Example: "tron-legacy-2010".
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("movies/{id}/comments/{sort}")
    suspend fun comments(
        @Path("id") movieId: String,
        @Path("sort") sort: CommentSort? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<Comment>?

    /**
     * Returns all lists that contain this movie. By default, personal lists are returned sorted by the most popular.
     *
     * @param movieId trakt ID, trakt slug, or IMDB ID. Example: "tron-legacy-2010".
     * @param type Filter for a specific list type.
     * @param sort How to sort.
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("movies/{id}/lists/{type}/{sort}")
    suspend fun lists(
        @Path("id") movieId: String,
        @Path("type") type: ListType? = null,
        @Path("sort") sort: ListSort? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): List<TraktList>?

    /**
     * Returns all actors, directors, writers, and producers for a movie.
     *
     * @param movieId trakt ID, trakt slug, or IMDB ID. Example: "tron-legacy-2010".
     */
    @GET("movies/{id}/people")
    suspend fun people(
        @Path("id") movieId: String
    ): Credits?

    /**
     * Returns rating (between 0 and 10) and distribution for a movie.
     *
     * @param movieId trakt ID, trakt slug, or IMDB ID. Example: "tron-legacy-2010".
     */
    @GET("movies/{id}/ratings")
    suspend fun ratings(
        @Path("id") movieId: String
    ): Ratings?

    /**
     * Returns related and similar movies.
     *
     * @param movieId trakt ID, trakt slug, or IMDB ID. Example: "tron-legacy-2010".
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("movies/{id}/related")
    suspend fun related(
        @Path("id") movieId: String,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<Movie>

    /**
     * Returns lots of movie stats.
     *
     * @param movieId trakt ID, trakt slug, or IMDB ID. Example: "tron-legacy-2010".
     */
    @GET("movies/{id}/stats")
    suspend fun stats(
        @Path("id") movieId: String
    ): Stats?

    /**
     * Returns all users watching this movie right now.
     *
     * @param movieId trakt ID, trakt slug, or IMDB ID. Example: "tron-legacy-2010".
     */
    @GET("movies/{id}/watching")
    suspend fun watching(
        @Path("id") movieId: String,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<User>?
}