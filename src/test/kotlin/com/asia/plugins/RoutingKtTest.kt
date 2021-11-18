package com.asia.plugins

import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class RoutingKtTest {

    @Test
    fun testGetHello() {
        withTestApplication({ configureRouting() }) {
            handleRequest(HttpMethod.Get, "/hello?name=abc").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World! abc", response.content)
            }
        }
    }
}