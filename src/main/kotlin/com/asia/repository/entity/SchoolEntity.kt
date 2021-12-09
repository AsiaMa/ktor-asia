package com.asia.repository.entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.timestamp
import java.time.Instant

object SchoolTable : IntIdTable("school") {
    val name: Column<String> = varchar("name", 64)
    val address: Column<String> = varchar("address", 1024)
    val createTime: Column<Instant> = timestamp("create_time").default(Instant.now())
    val updateTime: Column<Instant> = timestamp("update_time").default(Instant.now())
}

class SchoolEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<SchoolEntity>(SchoolTable)

    var name by SchoolTable.name
    var address by SchoolTable.address
    val students by StudentEntity referrersOn StudentTable.school
    var createTime by SchoolTable.createTime
    var updateTime by SchoolTable.updateTime
}