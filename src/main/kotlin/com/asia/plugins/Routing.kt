package com.asia.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.slf4j.event.Level

fun Application.configureRouting() {
    install(DefaultHeaders)
    install(CallLogging) {
        level = Level.DEBUG

        filter { call ->
            call.request.path().startsWith("/api")
        }

        format { call ->
            val status = call.response.status()
            val httpMethod = call.request.httpMethod.value
            val userAgent = call.request.headers["User-Agent"]
            "Status: $status, HTTP method: $httpMethod, User agent: $userAgent"
        }

        mdc("name-parameter") { call ->
            call.request.queryParameters["name"]
        }
    }

    // Starting point for a Ktor app:
    routing {
        get("/hello") {
            call.respondText("Hello World!")
        }
    }
    routing {

    }
}
