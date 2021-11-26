package com.asia.db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.experimental.suspendedTransactionAsync
import org.slf4j.LoggerFactory
import javax.sql.DataSource

interface IDatabaseFactory {
    fun init()

    suspend fun <T> dbQuery(block: () -> T): T

    suspend fun <T> dbQueryWithDB(block: () -> T, db: Database?): T
}

class DatabaseFactory : IDatabaseFactory {
    private val logger = LoggerFactory.getLogger(this::class.java.simpleName)

    private lateinit var defaultDB: Database
    override fun init() {
        val pool = hikari()
        defaultDB = Database.connect(pool)

        runFlyway(pool)
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig().apply {
            driverClassName = "com.mysql.cj.jdbc.Driver"
            jdbcUrl = "jdbc:mysql://localhost/my_ktor?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT"
            username = "root"
            password = "123456"
            maximumPoolSize = 10
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            validate()
        }
        return HikariDataSource(config)
    }

    private fun runFlyway(datasource: DataSource) {
        val flyway = Flyway.configure()
            .dataSource(datasource)
            .locations("classpath:com/asia/db/migration", "classpath:db/migration/mysql")
            .load()
        try {
            flyway.info()
            flyway.migrate()
        } catch (e: Exception) {
            logger.error("Exception running flyway migration", e)
            throw e
        }

        logger.info("Flyway migration has finished")
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