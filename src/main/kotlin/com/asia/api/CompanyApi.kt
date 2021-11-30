package com.asia.api

import com.asia.controller.CompanyController
import io.ktor.application.*
import io.ktor.routing.*

fun Route.company() {
    post("/company") {
        CompanyController.save(call)
    }
}