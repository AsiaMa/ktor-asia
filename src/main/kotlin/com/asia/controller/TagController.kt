package com.asia.controller

import com.asia.service.TagService
import io.ktor.application.*
import io.ktor.response.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object TagController : KoinComponent {
    private val tagService: TagService by inject()

    suspend fun list(call: ApplicationCall) {
        val tagEntityList = tagService.list()

        transaction {

            tagEntityList.forEach { tagEntity ->
                val articles = tagEntity.articles

                articles.forEach { articleEntity ->
                    val description = articleEntity.description
                    val a = 11
                }
            }
        }
        call.respond("OK")
    }

}
