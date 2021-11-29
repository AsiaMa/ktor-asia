package com.asia.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LottoVO(val lotto: Lotto)

@Serializable
data class Lotto(
    val lottoId: Int,
    @SerialName("winning-numbers") val winningNumbers: List<Int>,
    val winners: List<Winner>
)

@Serializable
data class Winner(val winnerId: Int, val numbers: List<Int>)