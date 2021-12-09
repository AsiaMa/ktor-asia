package com.asia.repository.entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.timestamp
import java.time.Instant

object StudentTable : IntIdTable("student") {
    val name: Column<String> = varchar("name", 64).default("")
    val age: Column<Int> = integer("age").default(0)
    val schoolId = reference("school_id", SchoolTable)
    val createTime: Column<Instant> = timestamp("create_time").default(Instant.now())
    val updateTime: Column<Instant> = timestamp("update_time").default(Instant.now())
}

class StudentEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<StudentEntity>(StudentTable)

    var name by StudentTable.name
    var age by StudentTable.age
    val school by StudentTable.schoolId
    val createTime by StudentTable.createTime
    val updateTable by StudentTable.updateTime
}



