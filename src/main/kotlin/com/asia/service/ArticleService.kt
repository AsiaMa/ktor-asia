package com.asia.service

import com.asia.repository.ArticleRepository
import com.asia.repository.entity.ArticleEntity

class ArticleService(private val articleRepository: ArticleRepository) {

    suspend fun list(): List<ArticleEntity> {
        return articleRepository.list()
    }

}
