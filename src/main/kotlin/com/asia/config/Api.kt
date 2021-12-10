package com.asia.config

import com.asia.api.*
import io.ktor.routing.*

fun Route.api() {
    route("/api") {
        hello()
        lotto()
        company()
        school()
        student()
        article()
    }
}