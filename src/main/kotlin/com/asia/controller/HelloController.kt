package com.asia.controller

import io.ktor.application.*
import io.ktor.response.*
import org.slf4j.MDC

object HelloController {

    suspend fun hello(call: ApplicationCall) {
        val name = MDC.get("name-parameter")
        call.respondText("Hello World! sdf $name")
    }
}