package com.asia.repository

import com.asia.db.IDatabaseFactory
import com.asia.repository.entity.StudentEntity

class StudentRepository(private val database: IDatabaseFactory) {

    suspend fun list(): List<StudentEntity> {
        return database.dbQuery {
            StudentEntity.all().toList()
        }
    }

}
