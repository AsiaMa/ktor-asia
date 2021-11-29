package com.asia.config

import com.asia.util.UserDoesNotExists
import com.asia.util.UserExists
import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

fun StatusPages.Configuration.statusPages() {
    exception<RuntimeException> { cause ->
        call.respond(HttpStatusCode.InternalServerError, cause.message ?: "no message")
    }

    exception<UserExists> {
        call.respond(HttpStatusCode.UnprocessableEntity, mapOf("errors" to mapOf("user" to listOf("exists"))))
    }

    exception<UserDoesNotExists> {
        call.respond(HttpStatusCode.NotFound)
    }

    exception<MissingKotlinParameterException> { cause ->
        call.respond(
            HttpStatusCode.UnprocessableEntity,
            mapOf("errors" to mapOf(cause.parameter.name to listOf("can't be empty")))
        )
    }
}