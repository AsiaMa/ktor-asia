package com.asia.config

import com.asia.api.company
import com.asia.api.hello
import com.asia.api.lotto
import com.asia.api.school
import io.ktor.routing.*

fun Route.api() {
    route("/api") {
        hello()
        lotto()
        company()
        school()
    }
}