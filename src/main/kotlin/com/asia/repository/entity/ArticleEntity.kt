package com.asia.repository.entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object ArticleTable : IntIdTable("article") {
    val title = varchar("title", 255)
    val description = varchar("description", 255)
    val author = reference("student_id", StudentTable)
}


class ArticleEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ArticleEntity>(ArticleTable)

    var title by ArticleTable.title
    var description by ArticleTable.description
    var author by StudentEntity referencedOn ArticleTable.author
    var tags by TagEntity via ArticleTagTable
}


object ArticleTagTable : Table("article_tag") {
    private val article = reference(
        "article_id",
        ArticleTable,
        onDelete = ReferenceOption.CASCADE,
        onUpdate = ReferenceOption.CASCADE
    )
    private val tag = reference(
        "tag_id",
        TagTable,
        onDelete = ReferenceOption.CASCADE,
        onUpdate = ReferenceOption.CASCADE
    )

    override val primaryKey = PrimaryKey(article, tag)
}