package com.asia.api

import com.asia.controller.StudentController
import io.ktor.application.*
import io.ktor.routing.*

fun Route.student() {

    get("/student") {
        StudentController.list(call)
    }
}