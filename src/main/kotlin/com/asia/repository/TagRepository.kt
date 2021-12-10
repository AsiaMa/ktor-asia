package com.asia.repository

import com.asia.db.IDatabaseFactory
import com.asia.repository.entity.TagEntity

class TagRepository(private val database: IDatabaseFactory) {

    suspend fun list(): List<TagEntity> {
        return database.dbQuery {
            TagEntity.all().toList()
        }
    }

}
