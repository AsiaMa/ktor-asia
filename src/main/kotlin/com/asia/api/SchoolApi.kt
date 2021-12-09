package com.asia.api

import com.asia.controller.SchoolController
import io.ktor.application.*
import io.ktor.routing.*

fun Route.school() {
    get("/school") {
        SchoolController.list(call)
    }
}