package com.asia.repository.entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object CompanyTable : IntIdTable("company") {
    val name: Column<String> = varchar("name", 128)
    val tel: Column<String> = varchar("tel", 32)
}

class CompanyEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CompanyEntity>(CompanyTable)

    var name by CompanyTable.name
    var tel by CompanyTable.tel
}