package com.asia.plugins

import com.asia.databaseKoinModule
import io.ktor.application.*
import org.koin.ktor.ext.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin(){
    install(Koin){
        slf4jLogger()
        modules(databaseKoinModule)
    }
}