package com.asia.dao

import com.asia.entity.UserTable
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.suspendedTransactionAsync
import org.jetbrains.exposed.sql.transactions.transaction

interface IDatabaseFactory {
    fun init()

    suspend fun <T> dbQueryWithDB(block: () -> T, db: Database?): T

    suspend fun <T> dbQuery(block: () -> T): T
}

class DatabaseFactory : IDatabaseFactory {
    private lateinit var defaultDB: Database
    override fun init() {
        defaultDB = Database.connect(hikari())

        transaction {
            SchemaUtils.create(UserTable)
        }
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig().apply {
            driverClassName = "com.mysql.cj.jdbc.Driver"
            jdbcUrl = "jdbc:mysql://localhost/oasis_oa"
            username = "localhost"
            password = "123456"
            maximumPoolSize = 10
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        }
        return HikariDataSource(config)
    }

    override suspend fun <T> dbQuery(block: () -> T): T {
        val launchResult = suspendedTransactionAsync(Dispatchers.IO) {
            block()
        }
        return launchResult.await()
    }

    override suspend fun <T> dbQueryWithDB(block: () -> T, db: Database?): T {
        val launchResult = suspendedTransactionAsync(Dispatchers.IO, db = db ?: defaultDB) {
            block()
        }
        return launchResult.await()
    }
}