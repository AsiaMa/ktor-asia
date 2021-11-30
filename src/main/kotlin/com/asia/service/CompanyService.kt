package com.asia.service

import com.asia.controller.CompanyQuery
import com.asia.repository.CompanyRepository

class CompanyService(private val companyRepository: CompanyRepository) {
    suspend fun save(company: CompanyQuery) {
        companyRepository.save(company)
    }
}