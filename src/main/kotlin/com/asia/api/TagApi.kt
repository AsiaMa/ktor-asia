package com.asia.api

import com.asia.controller.TagController
import io.ktor.application.*
import io.ktor.routing.*

fun Route.tag() {

    get("/tag") {
        TagController.list(call)
    }
}