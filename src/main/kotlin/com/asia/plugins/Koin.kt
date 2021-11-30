package com.asia.plugins

import com.asia.initlization.databaseKoinModule
import com.asia.initlization.repositoryKoinModule
import com.asia.initlization.serviceKoinModule
import io.ktor.application.*
import org.koin.ktor.ext.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger()
        modules(serviceKoinModule)
        modules(repositoryKoinModule)
        modules(databaseKoinModule)
    }
}