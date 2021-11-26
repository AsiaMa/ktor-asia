package com.asia.plugins

import com.asia.util.JsonMapper
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(JsonMapper.defaultMapper)
    }
}