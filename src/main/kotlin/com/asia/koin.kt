package com.asia

import com.asia.initlization.DatabaseFactory
import com.asia.initlization.IDatabaseFactory
import org.koin.dsl.module

val databaseKoinModule = module(createdAtStart = true) {
    single<IDatabaseFactory> { DatabaseFactory() }
}