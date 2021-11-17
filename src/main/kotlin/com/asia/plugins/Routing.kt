package com.asia.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {
    // add Server and Date headers into each response
    /*
       Date: Wed, 17 Nov 2021 11:33:30 GMT
       Server: ktor-server-core/1.6.5
    */
    install(DefaultHeaders)
    install(CallLogging) {
        // 改变日志的级别 default: Level.INFO
//        level = Level.TRACE

        filter { call ->
            call.request.path().startsWith("/he")
        }

        format { call ->
            val uri = call.request.uri
            val status = call.response.status()
            val httpMethod = call.request.httpMethod.value
            val userAgent = call.request.headers["User-Agent"]
            "uri: $uri, Status: $status, HTTP method: $httpMethod, User agent: $userAgent"
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
