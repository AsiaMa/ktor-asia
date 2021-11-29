package com.asia.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.slf4j.MDC

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

        // 过滤
        filter { call ->
            call.request.path().startsWith("/he")
        }

        // 格式化日志输出
        format { call ->
            val uri = call.request.uri
            val status = call.response.status()
            val httpMethod = call.request.httpMethod.value
            val userAgent = call.request.headers["User-Agent"]
            "uri: $uri, Status: $status, HTTP method: $httpMethod, User agent: $userAgent"
        }

        // 类似于 ThreadLocal
        mdc("name-parameter") { call ->
            call.request.queryParameters["name"]
        }
    }

    // Starting point for a Ktor app:
    routing {
        get("/hello") {
            val name = MDC.get("name-parameter")
            call.respondText("Hello World! $name")
        }
    }
    routing {
        get("/lotto") {
            val json =
                """{"lotto":{"lottoId":5,"winning-numbers":[2,45,34,23,7,5,3],"winners":[{"winnerId":23,"numbers":[2,45,34,23,3,5]},{"winnerId":54,"numbers":[52,3,12,11,18,22]}]}}"""
            call.respondText(json)
        }
    }
}
