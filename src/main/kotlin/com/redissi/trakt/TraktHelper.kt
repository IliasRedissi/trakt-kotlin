package com.redissi.trakt

import com.redissi.moshi.adapter.iso8601.jdk8.LocalDateAdapter
import com.redissi.moshi.adapter.iso8601.jdk8.OffsetDateTimeAdapter
import com.redissi.trakt.internal.*
import com.squareup.moshi.Moshi

object TraktHelper {

    val moshiBuilder: Moshi.Builder = Moshi.Builder()
        .add(ListPrivacyAdapter())
        .add(SortByAdapter())
        .add(SortHowAdapter())
        .add(RatingAdapter())
        .add(PeriodAdapter())
        .add(ReleaseTypeAdapter())
        .add(CommentSortAdapter())
        .add(ListSortAdapter())
        .add(ListTypeAdapter())
        // trakt exclusively uses ISO 8601 date times with milliseconds and time zone offset
        // such as '2011-12-03T10:15:30.000+01:00' or '2011-12-03T10:15:30.000Z'
        .add(OffsetDateTimeAdapter())
        // dates are in ISO 8601 format as well
        .add(LocalDateAdapter())

}