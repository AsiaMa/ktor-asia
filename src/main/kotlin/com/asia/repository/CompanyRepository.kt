package com.asia.repository

import com.asia.controller.CompanyQuery
import com.asia.db.IDatabaseFactory
import com.asia.repository.entity.CompanyTable
import org.jetbrains.exposed.sql.insert

class CompanyRepository(private val database: IDatabaseFactory) {
    suspend fun save(company: CompanyQuery) {
        database.dbQuery {
            CompanyTable.insert {
                it[name] = company.name
                it[tel] = company.tel
            }
        }
    }
}