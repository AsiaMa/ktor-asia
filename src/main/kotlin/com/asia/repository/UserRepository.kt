package com.asia.repository

import com.asia.db.IDatabaseFactory
import com.asia.repository.entity.UserEntity
import com.asia.repository.entity.UserTable
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