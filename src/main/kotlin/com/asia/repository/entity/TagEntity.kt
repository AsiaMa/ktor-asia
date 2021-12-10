package com.asia.repository.entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object TagTable : IntIdTable("tag") {
    val tagName = varchar("tag_name", 255).uniqueIndex()
}

class TagEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TagEntity>(TagTable)

    var tag by TagTable.tagName
    var articles by ArticleEntity via ArticleTagTable
}

