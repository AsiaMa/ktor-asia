package com.asia.controller

import com.asia.service.CompanyService
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object CompanyController : KoinComponent {
    private val companyService: CompanyService by inject()

    suspend fun save(call: ApplicationCall) {
        val company = call.receive<CompanyQuery>()
        companyService.save(company)
        call.respond(HttpStatusCode.Created, "ok")
    }
}

data class CompanyQuery(val name: String, val tel: String)