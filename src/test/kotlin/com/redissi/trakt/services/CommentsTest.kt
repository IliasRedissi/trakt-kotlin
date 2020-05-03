package com.redissi.trakt.services

import com.redissi.trakt.BaseTestCase
import com.redissi.trakt.TestData
import com.redissi.trakt.TestMovie
import com.redissi.trakt.TestResponse
import com.redissi.trakt.entities.*
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEmpty
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldNotBeEmpty
import org.amshove.kluent.shouldNotBeNull
import org.junit.Test
import java.io.IOException
import java.net.HttpURLConnection

class CommentsTest : BaseTestCase(), TestResponse, TestMovie {
    @Test
    @Throws(InterruptedException::class, IOException::class)
    fun `post and update a comment`() = runBlocking<Unit> {
        // first post a new comment
        val comment = Comment.build(
            buildTestEpisode(),
            "This is a toasty comment!",
            spoiler = true,
            review = false
        )
        var commentResponse = trakt.comments().post(comment)

        commentResponse.shouldNotBeNull()
        commentResponse.id.shouldNotBeNull()

        // update the new comment
        val updatedComment = Comment.build("This is toasty! I was just updated.", spoiler = false, review = false)
        commentResponse = trakt.comments().update(commentResponse.id!!, updatedComment)

        commentResponse.shouldNotBeNull()

        assertCommentResponse(updatedComment, commentResponse)

        // delete the comment again
        val response = trakt.comments().delete(commentResponse.id!!)
        assertSuccessfulResponse(response, trakt)
        response.code().shouldBeEqualTo(HttpURLConnection.HTTP_NO_CONTENT)
    }

    @Test
    @Throws(InterruptedException::class, IOException::class)
    fun `delete a comment`() = runBlocking<Unit> {
        // first post a new comment
        val comment = Comment.build(
            buildTestEpisode(),
            "This is toasty! I should be deleted soon.",
            spoiler = true,
            review = false
        )
        val commentResponse = trakt.comments().post(comment)

        commentResponse.shouldNotBeNull()
        commentResponse.id.shouldNotBeNull()

        // delete the comment again
        val response = trakt.comments().delete(commentResponse.id!!)
        assertSuccessfulResponse(response, trakt)
        response.code().shouldBeEqualTo(HttpURLConnection.HTTP_NO_CONTENT)
    }

    @Test
    @Throws(InterruptedException::class, IOException::class)
    fun `reply to a comment`() = runBlocking<Unit> {
        // first post a new comment
        val comment = Comment.build(
            buildTestEpisode(),
            "This is a toasty comment!",
            spoiler = true,
            review = false
        )
        val response = trakt.comments().post(comment)
        response.shouldNotBeNull()
        response.id.shouldNotBeNull()
        // post a reply to the new comment
        val expectedReply = Comment.build("This is a reply to the toasty comment!", spoiler = false, review = false)
        val actualReply = trakt.comments().postReply(response.id!!, expectedReply)
        actualReply.shouldNotBeNull()
        actualReply.id.shouldNotBeNull()
        assertCommentResponse(expectedReply, actualReply)
        // look if the comment replies include our new reply
        val replies = trakt.comments().replies(response.id!!)
        replies.shouldNotBeNull()
        for (reply in replies) {
            if (reply.id == actualReply.id) {
                assertCommentResponse(actualReply, reply)
            }
        }
        // delete the comment and replies (does this work?)
        val deleteResponse = trakt.comments().delete(response.id!!)
        assertSuccessfulResponse(deleteResponse, trakt)
        deleteResponse.code().shouldBeEqualTo(HttpURLConnection.HTTP_NO_CONTENT)
    }

    @Test
    fun `get movie item`() = runBlocking<Unit> {
        val comment = Comment.build(
            buildTestMovie(),
            "This is a toasty comment!",
            spoiler = true,
            review = false
        )

        val response = trakt.comments().post(comment)
        response.shouldNotBeNull()
        response.id.shouldNotBeNull()

        val itemResponse = trakt.comments().item(response.id!!)
        itemResponse.shouldNotBeNull()
        itemResponse.type.shouldNotBeNull().shouldBeEqualTo("movie")
        itemResponse.movie.shouldNotBeNull()
        assertTestMovie(itemResponse.movie!!)

        val deleteResponse = trakt.comments().delete(response.id!!)
        assertSuccessfulResponse(deleteResponse, trakt)
        deleteResponse.code().shouldBeEqualTo(HttpURLConnection.HTTP_NO_CONTENT)
    }

    @Test
    fun `get show item`() = runBlocking<Unit> {
        val comment = Comment.build(
            buildTestShow(),
            "This is a toasty comment!",
            spoiler = true,
            review = false
        )

        val response = trakt.comments().post(comment)
        response.shouldNotBeNull()
        response.id.shouldNotBeNull()

        val itemResponse = trakt.comments().item(response.id!!)
        itemResponse.shouldNotBeNull()
        itemResponse.type.shouldNotBeNull().shouldBeEqualTo("show")
        itemResponse.show.shouldNotBeNull()

        val deleteResponse = trakt.comments().delete(response.id!!)
        assertSuccessfulResponse(deleteResponse, trakt)
        deleteResponse.code().shouldBeEqualTo(HttpURLConnection.HTTP_NO_CONTENT)
    }

    @Test
    fun `get season item`() = runBlocking<Unit> {
        val comment = Comment.build(
            buildTestSeason(),
            "This is a toasty comment!",
            spoiler = true,
            review = false
        )

        val response = trakt.comments().post(comment)
        response.shouldNotBeNull()
        response.id.shouldNotBeNull()

        val itemResponse = trakt.comments().item(response.id!!)
        itemResponse.shouldNotBeNull()
        itemResponse.type.shouldNotBeNull().shouldBeEqualTo("season")
        itemResponse.season.shouldNotBeNull()

        val deleteResponse = trakt.comments().delete(response.id!!)
        assertSuccessfulResponse(deleteResponse, trakt)
        deleteResponse.code().shouldBeEqualTo(HttpURLConnection.HTTP_NO_CONTENT)
    }

    @Test
    fun `get episode item`() = runBlocking<Unit> {
        val comment = Comment.build(
            buildTestEpisode(),
            "This is a toasty comment!",
            spoiler = true,
            review = false
        )

        val response = trakt.comments().post(comment)
        response.shouldNotBeNull()
        response.id.shouldNotBeNull()

        val itemResponse = trakt.comments().item(response.id!!)
        itemResponse.shouldNotBeNull()
        itemResponse.type.shouldNotBeNull().shouldBeEqualTo("episode")
        itemResponse.episode.shouldNotBeNull()

        val deleteResponse = trakt.comments().delete(response.id!!)
        assertSuccessfulResponse(deleteResponse, trakt)
        deleteResponse.code().shouldBeEqualTo(HttpURLConnection.HTTP_NO_CONTENT)
    }

    @Test
    fun `get list item`() = runBlocking<Unit> {
        val comment = Comment.build(
            buildTestList(),
            "This is a toasty comment!",
            spoiler = true,
            review = false
        )

        val response = trakt.comments().post(comment)
        response.shouldNotBeNull()
        response.id.shouldNotBeNull()

        val itemResponse = trakt.comments().item(response.id!!)
        itemResponse.shouldNotBeNull()
        itemResponse.type.shouldNotBeNull().shouldBeEqualTo("list")
        itemResponse.list.shouldNotBeNull()

        val deleteResponse = trakt.comments().delete(response.id!!)
        assertSuccessfulResponse(deleteResponse, trakt)
        deleteResponse.code().shouldBeEqualTo(HttpURLConnection.HTTP_NO_CONTENT)
    }

    @Test
    fun `get all users who liked a comment`() = runBlocking<Unit> {
        // create a comment
        val comment = Comment.build(
            buildTestEpisode(),
            "This is a toasty comment!",
            spoiler = true,
            review = false
        )
        val response = trakt.comments().post(comment)
        response.shouldNotBeNull()
        response.id.shouldNotBeNull()

        var likesResponse = trakt.comments().likes(response.id!!)
        likesResponse.shouldNotBeNull().shouldBeEmpty()

        // like the comment
        trakt.comments().postLike(response.id!!)

        likesResponse = trakt.comments().likes(response.id!!)
        likesResponse.shouldNotBeNull().shouldNotBeEmpty()

        // delete the comment
        val deleteResponse = trakt.comments().delete(response.id!!)
        assertSuccessfulResponse(deleteResponse, trakt)
        deleteResponse.code().shouldBeEqualTo(HttpURLConnection.HTTP_NO_CONTENT)
    }

    @Test
    fun `like a comment`() = runBlocking<Unit> {
        // create a comment
        val comment = Comment.build(
            buildTestEpisode(),
            "This is a toasty comment!",
            spoiler = true,
            review = false
        )
        val response = trakt.comments().post(comment)
        response.shouldNotBeNull()
        response.id.shouldNotBeNull()

        // check likes
        val likesResponse = trakt.comments().likes(response.id!!)
        likesResponse.shouldNotBeNull().shouldBeEmpty()

        // like the comment
        val likeResponse = trakt.comments().postLike(response.id!!)
        likeResponse.shouldNotBeNull()
        likeResponse.code().shouldBeEqualTo(HttpURLConnection.HTTP_NO_CONTENT)

        // delete the comment
        val deleteResponse = trakt.comments().delete(response.id!!)
        assertSuccessfulResponse(deleteResponse, trakt)
        deleteResponse.code().shouldBeEqualTo(HttpURLConnection.HTTP_NO_CONTENT)
    }

    @Test
    fun `remove like on a comment`() = runBlocking<Unit> {
        // create a comment
        val comment = Comment.build(
            buildTestEpisode(),
            "This is a toasty comment!",
            spoiler = true,
            review = false
        )
        val response = trakt.comments().post(comment)
        response.shouldNotBeNull()
        response.id.shouldNotBeNull()

        var likesResponse = trakt.comments().likes(response.id!!)
        likesResponse.shouldNotBeNull().shouldBeEmpty()

        // like the comment
        val likeResponse = trakt.comments().postLike(response.id!!)
        likeResponse.shouldNotBeNull()
        likeResponse.code().shouldBeEqualTo(HttpURLConnection.HTTP_NO_CONTENT)


        likesResponse = trakt.comments().likes(response.id!!)
        likesResponse.shouldNotBeNull().shouldNotBeEmpty()

        // delete like
        val deleteLikeResponse = trakt.comments().deleteLike(response.id!!)
        deleteLikeResponse.shouldNotBeNull()
        deleteLikeResponse.code().shouldBeEqualTo(HttpURLConnection.HTTP_NO_CONTENT)


        likesResponse = trakt.comments().likes(response.id!!)
        likesResponse.shouldNotBeNull().shouldBeEmpty()

        // delete the comment
        val deleteResponse = trakt.comments().delete(response.id!!)
        assertSuccessfulResponse(deleteResponse, trakt)
        deleteResponse.code().shouldBeEqualTo(HttpURLConnection.HTTP_NO_CONTENT)
    }

    companion object {
        private fun assertCommentResponse(
            expected: Comment,
            actual: Comment
        ) {
            actual.comment.shouldBeEqualTo(expected.comment)
            actual.spoiler.shouldBeEqualTo(expected.spoiler)
            actual.review.shouldBeEqualTo(expected.review)
        }

        private fun buildTestEpisode(): Episode {
            return Episode(ids = EpisodeIds.tvdb(TestData.EPISODE_TVDB_ID))
        }

        private fun buildTestMovie(): Movie {
            return Movie(ids = MovieIds.tmdb(TestData.MOVIE_TMDB_ID))
        }

        private fun buildTestShow(): Show {
            return Show(ids = ShowIds.tmdb(TestData.SHOW_TMDB_ID))
        }

        private fun buildTestSeason(): Season {
            return Season(ids = SeasonIds(trakt = TestData.SEASON_TRAKT_ID))
        }

        private fun buildTestList(): TraktList {
            return TraktList(ids = ListIds(trakt = TestData.LIST_TRAKT_ID))
        }
    }
}