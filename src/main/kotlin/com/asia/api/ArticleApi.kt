package com.asia.api

import com.asia.controller.ArticleController
import io.ktor.application.*
import io.ktor.routing.*

fun Route.article() {
    get("article") {
        ArticleController.list(call)
    }
}