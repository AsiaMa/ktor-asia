package com.asia.web

import io.restassured.RestAssured.get
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.hasItems
import org.junit.jupiter.api.Test

class LottoControllerTest : BaseWebTest() {

    /**
     *
     *  {
     *   "lotto":{
     *       "lottoId":5,
     *       "winning-numbers":[2,45,34,23,7,5,3],
     *       "winners":[{
     *           "winnerId":23,
     *           "numbers":[2,45,34,23,3,5]
     *       },{
     *           "winnerId":54,
     *           "numbers":[52,3,12,11,18,22]
     *       }]
     *   }
     * }
     */
    @Test
    fun testGetLotto() {

        get("api/lotto")
            .then()
            .statusCode(200)
            .body("lotto.lottoId", equalTo(5))
    }

    @Test
    fun testGetLotto2() {
        get("api/lotto")
            .then()
            .body("lotto.winners.winnerId", hasItems(23, 54))
    }
}