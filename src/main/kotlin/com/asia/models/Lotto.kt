package com.asia.models

import com.fasterxml.jackson.annotation.JsonProperty

data class LottoVO(val lotto: Lotto)

data class Lotto(
    val lottoId: Int,
    @JsonProperty("winning-numbers") val winningNumbers: List<Int>,
    val winners: List<Winner>
)

data class Winner(val winnerId: Int, val numbers: List<Int>)