package com.asia.plugins

import com.asia.databaseKoinModule
import io.ktor.application.*
import org.koin.ktor.ext.Koin

fun Application.configureKoin(){
    install(Koin){
        modules(databaseKoinModule)
    }
}