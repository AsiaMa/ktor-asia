package com.asia.api

import com.asia.controller.HelloController
import io.ktor.application.*
import io.ktor.routing.*

fun Route.hello() {
    get("/hello") {
        HelloController.hello(call)
    }
}