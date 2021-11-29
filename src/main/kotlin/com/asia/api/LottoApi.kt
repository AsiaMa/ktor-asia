package com.asia.api

import com.asia.controller.LottoController
import io.ktor.application.*
import io.ktor.routing.*

fun Route.lotto() {
    get("/lotto") {
        LottoController.lotto(call)
    }
}
