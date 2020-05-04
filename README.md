trakt-kotlin
==========

A Kotlin wrapper around the [trakt v2 API](http://docs.trakt.apiary.io/) using [retrofit 2](https://square.github.io/retrofit/).

Pull requests are welcome.

Trakt methods are grouped into service objects which can be centrally
managed by a `Trakt` instance. It will act as a factory for
all the services and will automatically initialize them with your
API key (OAuth client id) and optionally a given user access token.

## Usage

<a href="https://search.maven.org/search?q=g:com.uwetrottmann.trakt5">Available on Maven Central</a>

Add the following dependency to your Gradle project:

```groovy
implementation("com.redissi.trakt:trakt-kotlin:1.0.0-SNAPSHOT")
```

Or for Maven:

```xml
<dependency>
  <groupId>com.redissi.trakt</groupId>
  <artifactId>trakt-kotlin</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

### Android
This library ships Java 8 bytecode and Java Time APIs. This requires Android Gradle Plugin 4.x.x or newer.

### Example

Use like any other retrofit2 based service. You only need to supply your 
[OAuth 2.0](https://www.digitalocean.com/community/tutorials/an-introduction-to-oauth-2) credentials and optional user
OAuth access token obtained from trakt.

`Trakt` provides some helper methods to handle the OAuth 2.0 flow.

```kotlin
val trakt = Trakt("api_key")
val traktShows = trakt.shows()
try {
    // Get trending shows
    val trendingShows = traktShows.trending(page = 1, extended = Extended.FULL)
    for (trending in trendingShows) {
        println("Title: ${trending.show.title}")
    }
} catch (e: Exception) {
    // handle exception
}
```

See test cases in `src/test/` for more examples and the [retrofit website](https://square.github.io/retrofit/) for configuration options.

## Use Proguard!
You likely will not use every method in this library, so it is probably useful to strip unused ones with Proguard.
Just apply the [Proguard rules for retrofit](https://square.github.io/retrofit/#download).

## License
Created by [Uwe Trottmann](https://uwetrottmann.com).

See full [list of contributors](https://github.com/IliasRedissi/trakt-kotlin/graphs/contributors).

Except where noted otherwise, released into the [public domain](UNLICENSE).
Do not just copy, make it better.
