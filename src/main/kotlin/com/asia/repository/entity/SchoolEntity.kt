package com.asia.repository.entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object SchoolTable : IntIdTable("school") {
    val name: Column<String> = varchar("name", 64)
    val address: Column<String> = varchar("address", 1024)

    // val createTime: Column<Instant> = timestamp("create_time").default(Instant.now())
    val createTime: Column<Int> = integer("create_time").default((System.currentTimeMillis() / 1000).toInt())
    val updateTime: Column<Int> = integer("update_time").default((System.currentTimeMillis() / 1000).toInt())
}

class SchoolEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<SchoolEntity>(SchoolTable)

    var name by SchoolTable.name
    var address by SchoolTable.address
    val students by StudentEntity referrersOn StudentTable.school
    var createTime by SchoolTable.createTime
    var updateTime by SchoolTable.updateTime
}