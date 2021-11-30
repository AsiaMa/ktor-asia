package com.asia.db.migration

import com.asia.repository.entity.CompanyTable
import org.flywaydb.core.api.migration.BaseJavaMigration
import org.flywaydb.core.api.migration.Context
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class V3__create_companys : BaseJavaMigration() {
    override fun migrate(context: Context?) {
        transaction {
            SchemaUtils.create(CompanyTable)
        }
    }
}