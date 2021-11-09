package com.asia.plugins

import com.asia.dao.IDatabaseFactory
import io.ktor.application.*
import org.koin.ktor.ext.inject

fun Application.configureDatabase(){
    val factory: IDatabaseFactory by inject()
    factory.init()
}