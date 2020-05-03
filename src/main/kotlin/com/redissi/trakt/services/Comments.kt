package com.redissi.trakt.services

import com.redissi.trakt.entities.Comment
import com.redissi.trakt.entities.Item
import com.redissi.trakt.entities.ListComment
import com.redissi.trakt.entities.ListLike
import com.redissi.trakt.enums.CommentType
import com.redissi.trakt.enums.Extended
import com.redissi.trakt.enums.Types
import retrofit2.Response
import retrofit2.http.*

interface Comments {
    /**
     * **OAuth Required**
     *
     *
     *  Add a new comment to a movie, show, episode, or list. If you add a review, it needs to be at least 200 words.
     * Also make sure to allow and encourage spoilers to be indicated in your app.
     *
     * @param comment A [Comment] with either a movie, show or episode set, plus comment and spoiler or review
     * flags.
     */
    @POST("comments")
    suspend fun post(
        @Body comment: Comment
    ): Comment?

    /**
     * **OAuth Required**
     *
     *
     *  Returns a single comment and indicates how many replies it has. Use GET /comments/:id/replies to get the
     * actual replies.
     *
     * @param id A specific comment ID. Example: 417.
     */
    @GET("comments/{id}")
    suspend fun get(
        @Path("id") id: Int
    ): Comment?

    /**
     * **OAuth Required**
     *
     *
     *  Update a single comment created within the last hour. The OAuth user must match the author of the comment in
     * order to update it.
     *
     * @param id A specific comment ID. Example: 417.
     * @param comment A [Comment] with comment and spoiler or review flags.
     */
    @PUT("comments/{id}")
    suspend fun update(
        @Path("id") id: Int,
        @Body comment: Comment
    ): Comment?

    /**
     * **OAuth Required**
     *
     *
     *  Delete a single comment created within the last hour. This also effectively removes any replies this comment
     * has. The OAuth user must match the author of the comment in order to delete it.
     *
     * @param id A specific comment ID. Example: 417.
     */
    @DELETE("comments/{id}")
    suspend fun delete(
        @Path("id") id: Int
    ): Response<Unit>

    /**
     * **OAuth Required**
     *
     *
     *  Returns all replies for a comment. It is possible these replies could have replies themselves, so in that
     * case you would just call GET /comment/:id/replies again with the new comment_id.
     *
     * @param id A specific comment ID. Example: 417.
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("comments/{id}/replies")
    suspend fun replies(
        @Path("id") id: Int,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): List<Comment>?

    /**
     * **OAuth Required**
     *
     *
     *  Add a new reply to an existing comment. Also make sure to allow and encourage spoilers to be indicated in
     * your app.
     *
     * @param id A specific comment ID. Example: 417.
     * @param comment A [Comment] with comment and spoiler or review flags.
     */
    @POST("comments/{id}/replies")
    suspend fun postReply(
        @Path("id") id: Int,
        @Body comment: Comment
    ): Comment?

    /**
     *
     *
     *
     *  Returns the media item this comment is attached to. The media type can be movie, show, season, episode,
     * or list and it also returns the standard media object for that media type.
     *
     * @param id A specific comment ID. Example: 417.
     * @param extended Request a different extended level of information.
     */
    @GET("comments/{id}/item")
    suspend fun item(
        @Path("id") id: Int,
        @Query("extended", encoded = true) extended: Extended? = null
    ): Item?

    /**
     *  Returns all users who liked a comment. If you only need the replies count, the main comment object
     * already has that, so no need to use this method.
     *
     * @param id A specific comment ID. Example: 417.
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     */
    @GET("comments/{id}/likes")
    suspend fun likes(
        @Path("id") id: Int,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): List<ListLike>?

    /**
     * **OAuth Required**
     *
     *  Votes help determine popular comments. Only one like is allowed per comment per user.
     *
     * @param id A specific comment ID. Example: 417.
     */
    @POST("comments/{id}/like")
    suspend fun postLike(
        @Path("id") id: Int
    ): Response<Unit>

    /**
     * **OAuth Required**
     *
     *  Remove a like on a comment.
     *
     * @param id A specific comment ID. Example: 417.
     */
    @DELETE("comments/{id}/like")
    suspend fun deleteLike(
        @Path("id") id: Int
    ): Response<Unit>

    /**
     *  Returns all comments with the most likes and replies over the last 7 days.
     *
     * @param includeReplies include comment replies
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     * @param extended Request a different extended level of information.
     */
    @GET("comments/trending")
    suspend fun trending(
        @Query("include_replies") includeReplies: Boolean? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query("extended", encoded = true) extended: Extended? = null
    ): List<ListComment>?

    /**
     *  Returns all comments with the most likes and replies over the last 7 days.
     *
     * @param commentType Filter by comment type. Example: reviews
     * @param type Filter by media type. Example: movies
     * @param includeReplies Include comment replies
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     * @param extended Request a different extended level of information.
     */
    @GET("comments/trending/{comment_type}/{type}")
    suspend fun trending(
        @Path("comment_type") commentType: CommentType,
        @Path("type") type: Types? = null,
        @Query("include_replies") includeReplies: Boolean? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query("extended", encoded = true) extended: Extended? = null
    ): List<ListComment>

    /**
     *  Returns the most recently written comments across all of Trakt.
     *
     * @param includeReplies include comment replies
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     * @param extended Request a different extended level of information.
     */
    @GET("comments/trending")
    suspend fun recentlyCreated(
        @Query("include_replies") includeReplies: Boolean? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query("extended", encoded = true) extended: Extended? = null
    ): List<ListComment>?

    /**
     *  Returns the most recently written comments across all of Trakt.
     *
     * @param commentType Filter by comment type. Example: reviews
     * @param type Filter by media type. Example: movies
     * @param includeReplies Include comment replies
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     * @param extended Request a different extended level of information.
     */
    @GET("comments/trending/{comment_type}/{type}")
    suspend fun recentlyCreated(
        @Path("comment_type") commentType: CommentType,
        @Path("type") type: Types? = null,
        @Query("include_replies") includeReplies: Boolean? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query("extended", encoded = true) extended: Extended? = null
    ): List<ListComment>

    /**
     *  Returns the most recently updated comments across all of Trakt.
     *
     * @param includeReplies include comment replies
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     * @param extended Request a different extended level of information.
     */
    @GET("comments/trending")
    suspend fun recentlyUpdated(
        @Query("include_replies") includeReplies: Boolean? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query("extended", encoded = true) extended: Extended? = null
    ): List<ListComment>?

    /**
     *  Returns the most recently updated comments across all of Trakt.
     *
     * @param commentType Filter by comment type. Example: reviews
     * @param type Filter by media type. Example: movies
     * @param includeReplies Include comment replies
     * @param page Number of page of results to be returned. If `null` defaults to 1.
     * @param limit Number of results to return per page. If `null` defaults to 10.
     * @param extended Request a different extended level of information.
     */
    @GET("comments/trending/{comment_type}/{type}")
    suspend fun recentlyUpdated(
        @Path("comment_type") commentType: CommentType,
        @Path("type") type: Types? = null,
        @Query("include_replies") includeReplies: Boolean? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query("extended", encoded = true) extended: Extended? = null
    ): List<ListComment>
}