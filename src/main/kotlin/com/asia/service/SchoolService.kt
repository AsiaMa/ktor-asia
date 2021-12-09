package com.asia.service

import com.asia.repository.SchoolRepository
import com.asia.repository.entity.SchoolEntity

class SchoolService(private val schoolRepository: SchoolRepository) {

    suspend fun list(): List<SchoolEntity> {
        return schoolRepository.list()
    }
}