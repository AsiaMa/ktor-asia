package com.asia.dao

import com.asia.entity.UserEntity
import com.asia.entity.UserTable
import org.jetbrains.exposed.sql.selectAll

class UserDao(private val database: IDatabaseFactory) {

    suspend fun list(): List<UserEntity> {
        return database.dbQuery {
            UserTable.selectAll()
                .map {
                    UserEntity.fromResultRow(it)
                }
        }
    }
}