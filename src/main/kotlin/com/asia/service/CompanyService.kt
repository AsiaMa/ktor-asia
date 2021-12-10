package com.asia.service

import com.asia.converter.CompanyConverter
import com.asia.models.query.CompanyQuery
import com.asia.repository.CompanyRepository
import org.mapstruct.factory.Mappers

class CompanyService(private val companyRepository: CompanyRepository) {
    private val converter = Mappers.getMapper(CompanyConverter::class.java)

    suspend fun save(company: CompanyQuery) {
        val companyBO = converter.convertToBO(company)

        companyRepository.save(companyBO)
    }
}