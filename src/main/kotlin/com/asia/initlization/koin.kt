package com.asia.initlization

import com.asia.db.DatabaseFactory
import com.asia.db.IDatabaseFactory
import com.asia.repository.CompanyRepository
import com.asia.repository.SchoolRepository
import com.asia.repository.StudentRepository
import com.asia.service.CompanyService
import com.asia.service.SchoolService
import com.asia.service.StudentService
import org.koin.dsl.module

val serviceKoinModule = module {
    single { CompanyService(get()) }
    single { SchoolService(get()) }
    single { StudentService(get()) }
}

val repositoryKoinModule = module {
    single { CompanyRepository(get()) }
    single { SchoolRepository(get()) }
    single { StudentRepository(get()) }
}

val databaseKoinModule = module(createdAtStart = true) {
    single<IDatabaseFactory> { DatabaseFactory() }
}