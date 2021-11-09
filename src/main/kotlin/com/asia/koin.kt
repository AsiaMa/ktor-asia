package com.asia

import com.asia.dao.DatabaseFactory
import com.asia.dao.IDatabaseFactory
import org.koin.dsl.module

val databaseKoinModule = module {
    single<IDatabaseFactory> { DatabaseFactory() }
}