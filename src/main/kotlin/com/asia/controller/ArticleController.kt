package com.asia.controller

import com.asia.service.ArticleService
import io.ktor.application.*
import io.ktor.response.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object ArticleController : KoinComponent {
    private val articleService: ArticleService by inject()

    suspend fun list(call: ApplicationCall) {
        val articleEntityList = articleService.list()

        transaction {
            articleEntityList.forEach { articleEntity ->
                val tagEntityList = articleEntity.tags
                tagEntityList.forEach { tagEntity ->
                    val tag = tagEntity.tagName
                    val a = 0
                }
            }
        }
        call.respond("OK")
    }
}
