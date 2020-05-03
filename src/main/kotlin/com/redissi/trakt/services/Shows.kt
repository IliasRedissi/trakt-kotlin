package com.redissi.trakt.services

import com.redissi.trakt.entities.*
import com.redissi.trakt.enums.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.LocalDate

interface Shows {
    /**
     * Returns the most popular shows. Popularity is calculated using the rating percentage and the number of ratings.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/popular")
    suspend fun popular(
        @Query("query") query: String? = null,
        @Query("years") years: String? = null,
        @Query("genres") genres: String? = null,
        @Query("languages") languages: String? = null,
        @Query("countries") countries: String? = null,
        @Query("runtimes") runtimes: String? = null,
        @Query("ratings") ratings: String? = null,
        @Query("certifications") certifications: String? = null,
        @Query("networks") networks: String? = null,
        @Query("status") status: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<Show>?

    /**
     * Returns all shows being watched right now. Shows with the most users are returned first.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/trending")
    suspend fun trending(
        @Query("query") query: String? = null,
        @Query("years") years: String? = null,
        @Query("genres") genres: String? = null,
        @Query("languages") languages: String? = null,
        @Query("countries") countries: String? = null,
        @Query("runtimes") runtimes: String? = null,
        @Query("ratings") ratings: String? = null,
        @Query("certifications") certifications: String? = null,
        @Query("networks") networks: String? = null,
        @Query("status") status: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<TrendingShow>?

    /**
     * Returns the most played (a single user can watch multiple episodes multiple times) shows
     * in the specified time period, defaulting to weekly. All stats are relative to the specific time period.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/played")
    suspend fun mostPlayed(
        @Query("query") query: String? = null,
        @Query("years") years: String? = null,
        @Query("genres") genres: String? = null,
        @Query("languages") languages: String? = null,
        @Query("countries") countries: String? = null,
        @Query("runtimes") runtimes: String? = null,
        @Query("ratings") ratings: String? = null,
        @Query("certifications") certifications: String? = null,
        @Query("networks") networks: String? = null,
        @Query("status") status: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<MostShow>?

    /**
     * Returns the most played (a single user can watch multiple episodes multiple times) shows
     * in the specified time period, defaulting to weekly. All stats are relative to the specific time period.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/played/{period}")
    suspend fun mostPlayed(
        @Path("period") period: Period,
        @Query("query") query: String? = null,
        @Query("years") years: String? = null,
        @Query("genres") genres: String? = null,
        @Query("languages") languages: String? = null,
        @Query("countries") countries: String? = null,
        @Query("runtimes") runtimes: String? = null,
        @Query("ratings") ratings: String? = null,
        @Query("certifications") certifications: String? = null,
        @Query("networks") networks: String? = null,
        @Query("status") status: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<MostShow>?

    /**
     * Returns the most watched (unique users) shows in the specified time period, defaulting to weekly.
     * All stats are relative to the specific time period.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/watched")
    suspend fun mostWatched(
        @Query("query") query: String? = null,
        @Query("years") years: String? = null,
        @Query("genres") genres: String? = null,
        @Query("languages") languages: String? = null,
        @Query("countries") countries: String? = null,
        @Query("runtimes") runtimes: String? = null,
        @Query("ratings") ratings: String? = null,
        @Query("certifications") certifications: String? = null,
        @Query("networks") networks: String? = null,
        @Query("status") status: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<MostShow>?

    /**
     * Returns the most watched (unique users) shows in the specified time period, defaulting to weekly.
     * All stats are relative to the specific time period.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/watched/{period}")
    suspend fun mostWatched(
        @Path("period") period: Period,
        @Query("query") query: String? = null,
        @Query("years") years: String? = null,
        @Query("genres") genres: String? = null,
        @Query("languages") languages: String? = null,
        @Query("countries") countries: String? = null,
        @Query("runtimes") runtimes: String? = null,
        @Query("ratings") ratings: String? = null,
        @Query("certifications") certifications: String? = null,
        @Query("networks") networks: String? = null,
        @Query("status") status: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<MostShow>?

    /**
     * Returns the most collected (unique users) shows in the specified time period, defaulting to weekly.
     * All stats are relative to the specific time period.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/collected")
    suspend fun mostCollected(
        @Query("query") query: String? = null,
        @Query("years") years: String? = null,
        @Query("genres") genres: String? = null,
        @Query("languages") languages: String? = null,
        @Query("countries") countries: String? = null,
        @Query("runtimes") runtimes: String? = null,
        @Query("ratings") ratings: String? = null,
        @Query("certifications") certifications: String? = null,
        @Query("networks") networks: String? = null,
        @Query("status") status: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<MostShow>?

    /**
     * Returns the most collected (unique users) shows in the specified time period, defaulting to weekly.
     * All stats are relative to the specific time period.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/collected/{period}")
    suspend fun mostCollected(
        @Path("period") period: Period,
        @Query("query") query: String? = null,
        @Query("years") years: String? = null,
        @Query("genres") genres: String? = null,
        @Query("languages") languages: String? = null,
        @Query("countries") countries: String? = null,
        @Query("runtimes") runtimes: String? = null,
        @Query("ratings") ratings: String? = null,
        @Query("certifications") certifications: String? = null,
        @Query("networks") networks: String? = null,
        @Query("status") status: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<MostShow>?

    /**
     * Returns the most anticipated shows based on the number of lists a show appears on.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/anticipated")
    suspend fun anticipated(
        @Query("query") query: String? = null,
        @Query("years") years: String? = null,
        @Query("genres") genres: String? = null,
        @Query("languages") languages: String? = null,
        @Query("countries") countries: String? = null,
        @Query("runtimes") runtimes: String? = null,
        @Query("ratings") ratings: String? = null,
        @Query("certifications") certifications: String? = null,
        @Query("networks") networks: String? = null,
        @Query("status") status: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<AnticipatedShow>?

    /**
     * Returns all shows updated since the specified UTC date.
     * We recommended storing the date you can be efficient using this method moving forward.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/updates")
    suspend fun recentlyUpdated(
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<UpdatedShow>?

    /**
     * Returns all shows updated since the specified UTC date.
     * We recommended storing the date you can be efficient using this method moving forward.
     *
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/updates/{start_date}")
    suspend fun recentlyUpdated(
        @Path("start_date") startDate: LocalDate,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<UpdatedShow>?

    /**
     * Returns a single shows's details.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     */
    @GET("shows/{id}")
    suspend fun summary(
        @Path("id") showId: String,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): Show?

    /**
     * Returns all title aliases for a show. Includes country where name is different.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     */
    @GET("shows/{id}/aliases")
    suspend fun aliases(
        @Path("id") showId: String
    ): List<Alias>?

    /**
     * Returns all translations for a show, including language and translated values for title and overview.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     */
    @GET("shows/{id}/translations")
    suspend fun translations(
        @Path("id") showId: String
    ): List<Translation>?

    /**
     * Returns a single translation for a show. If the translation does not exist, the returned list will be empty.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param language 2-letter language code (ISO 639-1).
     */
    @GET("shows/{id}/translations/{language}")
    suspend fun translation(
        @Path("id") showId: String,
        @Path("language") language: String
    ): List<Translation>?

    /**
     * Returns all top level comments for a show. Most recent comments returned first.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/{id}/comments")
    suspend fun comments(
        @Path("id") showId: String?,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<Comment>?

    /**
     * Returns all top level comments for a show. Most recent comments returned first.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/{id}/comments/{sort}")
    suspend fun comments(
        @Path("id") showId: String?,
        @Path("sort") sort: CommentSort,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<Comment>?

    /**
     * Returns all lists that contain this show. By default, personal lists are returned sorted by the most popular.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/{id}/lists")
    suspend fun lists(
        @Path("id") showId: String,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): List<TraktList>?

    /**
     * Returns all lists that contain this show. By default, personal lists are returned sorted by the most popular.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param type Filter for a specific list type.
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/{id}/lists/{type}")
    suspend fun lists(
        @Path("id") showId: String,
        @Path("type") type: ListType,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): List<TraktList>?

    /**
     * Returns all lists that contain this show. By default, personal lists are returned sorted by the most popular.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param type Filter for a specific list type.
     * @param sort How to sort.
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("shows/{id}/lists/{type}/{sort}")
    suspend fun lists(
        @Path("id") showId: String,
        @Path("type") type: ListType,
        @Path("sort") sort: ListSort,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): List<TraktList>?

    /**
     * **OAuth Required**
     *
     *
     * Returns collection progress for show including details on all seasons and episodes. The `next_episode`
     * will be the next episode the user should collect, if there are no upcoming episodes it will be set to `null`.
     *
     *
     * By default, any hidden seasons will be removed from the response and stats. To include these and adjust the
     * completion stats, set the `hidden` flag to `true`.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param hidden Include any hidden seasons.
     * @param specials Include specials as season 0.
     * @param countSpecials count specials in the overall stats (only applies if specials are included).
     */
    @GET("shows/{id}/progress/collection")
    suspend fun collectedProgress(
        @Path("id") showId: String,
        @Query("hidden") hidden: Boolean? = null,
        @Query("specials") specials: Boolean? = null,
        @Query("count_specials") countSpecials: Boolean? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): BaseShow?

    /**
     * **OAuth Required**
     *
     * Returns watched progress for show including details on all seasons and episodes. The `next_episode` will be
     * the next episode the user should watch, if there are no upcoming episodes it will be set to `null`.
     *
     *
     * By default, any hidden seasons will be removed from the response and stats. To include these and adjust the
     * completion stats, set the `hidden` flag to `true`.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param hidden Include any hidden seasons.
     * @param specials Include specials as season 0.
     * @param countSpecials count specials in the overall stats (only applies if specials are included).
     */
    @GET("shows/{id}/progress/watched")
    suspend fun watchedProgress(
        @Path("id") showId: String,
        @Query("hidden") hidden: Boolean? = null,
        @Query("specials") specials: Boolean? = null,
        @Query("count_specials") countSpecials: Boolean? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): BaseShow?

    /**
     * Returns all actors, directors, writers, and producers for a show.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     */
    @GET("shows/{id}/people")
    suspend fun people(
        @Path("id") showId: String
    ): Credits?

    /**
     * Returns rating (between 0 and 10) and distribution for a show.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     */
    @GET("shows/{id}/ratings")
    suspend fun ratings(
        @Path("id") showId: String
    ): Ratings?

    /**
     * Returns related and similar shows.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     */
    @GET("shows/{id}/related")
    suspend fun related(
        @Path("id") showId: String,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<Show>?

    /**
     * Returns lots of show stats.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     */
    @GET("shows/{id}/stats")
    suspend fun stats(
        @Path("id") showId: String
    ): Stats?

    /**
     * Returns all users watching this show right now.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     */
    @GET("shows/{id}/watching")
    suspend fun watching(
        @Path("id") showId: String,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): List<User>?

    /**
     * Returns the next scheduled to air episode.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     */
    @GET("shows/{id}/next_episode")
    suspend fun nextEpisode(
        @Path("id") showId: String,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): Episode?

    /**
     * Returns the most recently aired episode.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     */
    @GET("shows/{id}/last_episode")
    suspend fun lastEpisode(
        @Path("id") showId: String,
        @Query(value = "extended", encoded = true) extended: Extended? = null
    ): Episode?
}