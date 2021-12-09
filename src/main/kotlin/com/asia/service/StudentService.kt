package com.asia.service

import com.asia.repository.StudentRepository
import com.asia.repository.entity.StudentEntity

class StudentService(private val studentRepository: StudentRepository) {

    suspend fun list(): List<StudentEntity> {
        return studentRepository.list()
    }
}