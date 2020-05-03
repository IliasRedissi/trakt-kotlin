package com.redissi.trakt.services

import com.redissi.trakt.BaseTestCase
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldHaveKey
import org.amshove.kluent.shouldNotBeEmpty
import org.amshove.kluent.shouldNotBeNull
import org.junit.Test

class CertificationsTest : BaseTestCase() {

    @Test
    fun `get movies' certifications`() = runBlocking {
        val responses = trakt.certifications().movies()
        responses.shouldNotBeNull()
        val certifications = responses.shouldHaveKey("us")
        val usCertifications = certifications["us"].shouldNotBeNull().shouldNotBeEmpty()
        for (certification in usCertifications) {
            certification.name.shouldNotBeNull()
            certification.slug.shouldNotBeNull()
            certification.description.shouldNotBeNull()
        }
    }

    @Test
    fun `get shows' certifications`() = runBlocking {
        val responses = trakt.certifications().shows()
        responses.shouldNotBeNull()
        val certifications = responses.shouldHaveKey("us")
        val usCertifications = certifications["us"].shouldNotBeNull().shouldNotBeEmpty()
        for (certification in usCertifications) {
            certification.name.shouldNotBeNull()
            certification.slug.shouldNotBeNull()
            certification.description.shouldNotBeNull()
        }
    }

}