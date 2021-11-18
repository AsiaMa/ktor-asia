package com.asia

import com.asia.plugins.configureDatabase
import com.asia.plugins.configureKoin
import com.asia.plugins.configureRouting
import io.ktor.application.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureKoin()
    configureDatabase()
    configureRouting()
}
