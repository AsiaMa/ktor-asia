package com.asia.controller

import com.asia.service.StudentService
import io.ktor.application.*
import io.ktor.response.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object StudentController : KoinComponent {
    private val studentService: StudentService by inject()

    suspend fun list(call: ApplicationCall) {
        val studentEntityList = studentService.list()

        transaction {
            studentEntityList.forEach { studentEntity ->
                val schoolEntity = studentEntity.school
                val a = 0
            }
        }

        call.respond("PP")
    }

}
