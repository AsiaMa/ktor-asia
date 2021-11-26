package com.asia.initlization

import com.asia.db.DatabaseFactory
import com.asia.db.IDatabaseFactory
import org.koin.dsl.module

val databaseKoinModule = module(createdAtStart = true) {
    single<IDatabaseFactory> { DatabaseFactory() }
}