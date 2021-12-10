package com.asia.db.migration

import com.asia.repository.entity.*
import org.flywaydb.core.api.migration.BaseJavaMigration
import org.flywaydb.core.api.migration.Context
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.transactions.transaction

class V5__create_article_tag : BaseJavaMigration() {

    override fun migrate(context: Context?) {
        transaction {
            SchemaUtils.create(ArticleTable, TagTable, ArticleTagTable)
            val studentEntity = StudentEntity.findById(1) ?: StudentEntity.new {

            }

            val javaTag = TagEntity.new {
                tagName = "JAVA"
            }

            val kotlinTag = TagEntity.new {
                tagName = "Kotlin"
            }

            val cTag = TagEntity.new {
                tagName = "C"
            }


            val ganArticleEntity = ArticleEntity.new {
                title = "阿甘正传"
                description = "减肥都是辣椒粉"
                author = studentEntity
            }

            val studentEntity2 = StudentEntity.findById(2) ?: StudentEntity.new { }

            val phpTag = TagEntity.new {
                tagName = "PHP"
            }

            val niuArticleEntity = ArticleEntity.new {
                title = "放牛班的春天"
                description = "附近可撒了几句"
                author = studentEntity2
            }

            transaction {
                ganArticleEntity.tags = SizedCollection(listOf(javaTag, kotlinTag, cTag))
                niuArticleEntity.tags = SizedCollection(listOf(javaTag, phpTag))
            }

        }

    }
}