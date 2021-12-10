package com.asia.service

import com.asia.repository.TagRepository
import com.asia.repository.entity.TagEntity

class TagService(private val tagRepository: TagRepository) {

    suspend fun list(): List<TagEntity> {
        return tagRepository.list()
    }

}
