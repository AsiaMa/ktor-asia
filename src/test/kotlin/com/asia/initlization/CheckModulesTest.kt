package com.asia.initlization

import org.junit.Test
import org.koin.test.check.checkKoinModules

class CheckModulesTest {

    @Test
    fun `check modules`() = checkKoinModules(listOf(databaseKoinModule))
}