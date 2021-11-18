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

        val foldRightResult = listOf(1, 2, 3, 10, 4, 5).foldRight(0) { item, total ->
            total + item
        }
        assertThat(foldRightResult).isEqualTo(25)

        val foldIndexedResult = listOf(1, 2, 5, 10, 3, 6).foldIndexed(3) { index, total, item ->
            if (index < 3) {
                total + item
            } else total
        }
        assertThat(foldIndexedResult).isEqualTo(11)

        val foldRightIndexedResult = listOf(1, 2, 5, 10, 3, 6).foldRightIndexed(20) { index, item, total ->
            if (index < 3) {
                total + item
            } else total
        }

        assertThat(foldRightIndexedResult).isEqualTo(28)
    }

    @Test
    fun simpleReduce() {
        val reduceResult = listOf(1, 2, 3, 10, 4, 5).reduce { acc, i ->
            acc + i
        }
        assertThat(reduceResult).isEqualTo(25)
    }
}