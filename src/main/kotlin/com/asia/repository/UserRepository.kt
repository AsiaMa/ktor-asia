package com.asia.repository

import com.asia.entity.UserEntity
import com.asia.entity.UserTable
import com.asia.initlization.IDatabaseFactory
import org.jetbrains.exposed.sql.selectAll

class UserRepository(private val database: IDatabaseFactory) {

    suspend fun list(): List<UserEntity> {
        return database.dbQuery {
            UserTable.selectAll()
                .map {
                    UserEntity.fromResultRow(it)
                }
        }
    }
}