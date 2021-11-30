package com.asia.repository.entity

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object CompanyTable : IntIdTable("company") {
    val name: Column<String> = varchar("name", 128)
    val tel: Column<String> = varchar("tel", 32)
}