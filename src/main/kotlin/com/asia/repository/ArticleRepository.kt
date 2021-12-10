package com.asia.repository

import com.asia.db.IDatabaseFactory
import com.asia.repository.entity.ArticleEntity

class ArticleRepository(private val database: IDatabaseFactory) {

    suspend fun list(): List<ArticleEntity> {
        return database.dbQuery {
            ArticleEntity.all().toList()
        }
    }
}
