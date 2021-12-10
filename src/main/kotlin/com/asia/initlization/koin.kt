package com.asia.initlization

import com.asia.db.DatabaseFactory
import com.asia.db.IDatabaseFactory
import com.asia.repository.*
import com.asia.service.*
import org.koin.dsl.module

val serviceKoinModule = module {
    single { CompanyService(get()) }
    single { SchoolService(get()) }
    single { StudentService(get()) }
    single { ArticleService(get()) }
    single { TagService(get()) }
}

val repositoryKoinModule = module {
    single { CompanyRepository(get()) }
    single { SchoolRepository(get()) }
    single { StudentRepository(get()) }
    single { ArticleRepository(get()) }
    single { TagRepository(get()) }
}

val databaseKoinModule = module(createdAtStart = true) {
    single<IDatabaseFactory> { DatabaseFactory() }
}