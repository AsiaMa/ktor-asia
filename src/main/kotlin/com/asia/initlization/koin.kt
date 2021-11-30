package com.asia.initlization

import com.asia.db.DatabaseFactory
import com.asia.db.IDatabaseFactory
import com.asia.repository.CompanyRepository
import com.asia.service.CompanyService
import org.koin.dsl.module

val serviceKoinModule = module {
    single { CompanyService(get()) }
}

val repositoryKoinModule = module {
    single { CompanyRepository(get()) }
}

val databaseKoinModule = module(createdAtStart = true) {
    single<IDatabaseFactory> { DatabaseFactory() }
}