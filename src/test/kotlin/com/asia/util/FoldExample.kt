package com.asia.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FoldExample {

    @Test
    fun simpleFold() {
        val foldResult = listOf(1, 2, 3, 10, 4, 5).fold(0) { total, item ->
            total + item
        }
        assertThat(foldResult).isEqualTo(25)
    }

    @Test
    fun simpleReduce(){
        val reduceResult = listOf(1, 2, 3, 10, 4, 5).reduce { acc, i ->
            acc + i
        }
        assertThat(reduceResult).isEqualTo(25)
    }
}