package com.asia.config

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

fun StatusPages.Configuration.statusPages() {
    exception<RuntimeException> { cause ->
        call.respond(HttpStatusCode.InternalServerError, cause.message ?: "no message")
    }
}