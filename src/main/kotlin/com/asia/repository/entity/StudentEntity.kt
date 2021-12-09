package com.asia.repository.entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object StudentTable : IntIdTable("student") {
    val name: Column<String> = varchar("name", 64).default("")
    val age: Column<Int> = integer("age").default(0)
    val school = reference("school_id", SchoolTable)
    val createTime: Column<Int> = integer("create_time").default((System.currentTimeMillis() / 1000).toInt())
    val updateTime: Column<Int> = integer("update_time").default((System.currentTimeMillis() / 1000).toInt())
}

class StudentEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<StudentEntity>(StudentTable)

    var name by StudentTable.name
    var age by StudentTable.age
    var school by SchoolEntity referencedOn StudentTable.school
    val createTime by StudentTable.createTime
    val updateTime by StudentTable.updateTime
}



