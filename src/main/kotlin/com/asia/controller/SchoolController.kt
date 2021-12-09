package com.asia.controller

import com.asia.service.SchoolService
import io.ktor.application.*
import io.ktor.response.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object SchoolController : KoinComponent {
    private val schoolService: SchoolService by inject()

    suspend fun list(call: ApplicationCall) {
        val schoolEntityList = schoolService.list()
        transaction {
            schoolEntityList.forEach {
                val studentList = it.students
                studentList.forEach { studentEntity ->
                    val a = studentEntity
                    val c = 0
                }
            }
        }
        call.respond("OK")
    }

}