package com.asia.util

import org.junit.Test
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import java.util.*

class MDCTest {
    private val logger = LoggerFactory.getLogger(this::class.java.simpleName)
    private val key = "requestId"

    @Test
    fun simpleMDC() {
        // 入口传入请求ID
        MDC.put(key, UUID.randomUUID().toString())

        // 打印日志
        logger.debug("log in main thread 1")
        logger.debug("log in main thread 2")
        logger.debug("log in main thread 3")

        // 出口移除请求ID
        MDC.remove(key)
    }
}