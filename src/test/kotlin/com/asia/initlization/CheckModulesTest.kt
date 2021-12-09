package com.asia.initlization

import org.junit.Test

class CheckModulesTest {

    // @Test
    // fun `check modules`() = checkKoinModules(listOf(databaseKoinModule))

    @Test
    fun checkModules() = org.koin.test.check.checkModules {
        modules(databaseKoinModule)
    }
}