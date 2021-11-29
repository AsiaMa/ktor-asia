package com.asia.config

import com.asia.api.hello
import com.asia.api.lotto
import io.ktor.routing.*

fun Route.api() {
    route("/api") {
        hello()
        lotto()
    }
}