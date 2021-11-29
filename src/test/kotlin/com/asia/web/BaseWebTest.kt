package com.asia.web

import com.asia.module
import io.ktor.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeAll
import java.util.concurrent.TimeUnit

open class BaseWebTest {

    companion object {
        private var serverStarted = false
        private lateinit var server: ApplicationEngine

        @BeforeAll
        @JvmStatic
        fun startServer() {
            if (!serverStarted) {
                server = embeddedServer(Netty, 12306, module = Application::module)
                server.start()
                serverStarted = true

                RestAssured.baseURI = "http://localhost"
                RestAssured.port = 12306
                Runtime.getRuntime().addShutdownHook(Thread {
                    server.stop(0, 0, TimeUnit.SECONDS)
                })
            }
        }
    }
}