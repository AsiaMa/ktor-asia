package com.asia.controller

import com.asia.models.Lotto
import com.asia.models.LottoVO
import com.asia.models.Winner
import io.ktor.application.*
import io.ktor.response.*

object LottoController {

    suspend fun lotto(call: ApplicationCall) {
        val winner1 = Winner(23, listOf(2, 45, 34, 23, 3, 5))
        val winner2 = Winner(54, listOf(52, 3, 12, 11, 18, 22))

        val lotto = Lotto(5, listOf(2, 45, 34, 23, 7, 5, 3), listOf(winner1, winner2))

        val lottoVO = LottoVO(lotto = lotto)
        call.respond(lottoVO)
    }
}