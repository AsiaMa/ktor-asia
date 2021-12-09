package com.asia.db.migration

import com.asia.repository.entity.SchoolEntity
import com.asia.repository.entity.SchoolTable
import com.asia.repository.entity.StudentEntity
import com.asia.repository.entity.StudentTable
import org.flywaydb.core.api.migration.BaseJavaMigration
import org.flywaydb.core.api.migration.Context
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class V4__create_school_student : BaseJavaMigration() {
    override fun migrate(context: Context?) {
        transaction {
            SchemaUtils.create(SchoolTable, StudentTable)

            val sSchool = SchoolEntity.new {
                name = "斯坦福大学"
                address = "American"
            }

            StudentEntity.new {
                name = "Tom"
                age = 18
                school = sSchool
            }

            StudentEntity.new {
                name = "Alice"
                age = 19
                school = sSchool
            }

            val dSchool = SchoolEntity.new {
                name = "东京大学"
                address = "Japan"
            }

            StudentEntity.new {
                name = "树上春树"
                age = 16
                school = dSchool
            }
        }
    }
}