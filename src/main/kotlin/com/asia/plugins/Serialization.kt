package com.asia.plugins

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
//        json(JsonMapper.defaultMapper)
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
}