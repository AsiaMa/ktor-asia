package com.asia.plugins

import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RoutingKtTest {

    @Test
    fun testGetHello() {
        withTestApplication({ configureRouting() }) {
            handleRequest(HttpMethod.Get, "api/hello?name=abc").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World! abc", response.content)
            }
        }
    }
}