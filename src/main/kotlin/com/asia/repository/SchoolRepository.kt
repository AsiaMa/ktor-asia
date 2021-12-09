package com.asia.repository

import com.asia.db.IDatabaseFactory
import com.asia.repository.entity.SchoolEntity

class SchoolRepository(private val database: IDatabaseFactory) {

    suspend fun list(): List<SchoolEntity> {
        return database.dbQuery {
            SchoolEntity.all().toList()
        }
    }

}