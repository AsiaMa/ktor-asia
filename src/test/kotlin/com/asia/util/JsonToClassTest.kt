package com.asia.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class JsonToClassTest {

    val json = """
        {
            "name": "AsiaMa",
             "age": 20
        }
    """.trimIndent()

    @Test
    fun fromJsonByGson() {
        val gson = Gson()
        val stu = gson.fromJson(json, Student::class.java)
        stu.address.substring(1)
        println(stu)
    }

    @Test
    fun fromJsonByJackson() {
        val objectMapper = jacksonObjectMapper()
        val stu = objectMapper.readValue(json, Student::class.java)
        println(stu)
    }

    @Test
    fun fromJsonBySerialization() {
        val stu = Json.decodeFromString<Student>(json)
        println(stu)
    }
}

@Serializable
data class Student(val name: String, val age: Int, val address: String)

