package com.asia.repository

import com.asia.db.IDatabaseFactory
import com.asia.models.bo.CompanyBO
import com.asia.repository.entity.CompanyTable
import org.jetbrains.exposed.sql.insert

class CompanyRepository(private val database: IDatabaseFactory) {
    suspend fun save(companyBO: CompanyBO) {
        database.dbQuery {
            CompanyTable.insert {
                it[name] = companyBO.name
                it[tel] = companyBO.tel
            }
        }
    }
}