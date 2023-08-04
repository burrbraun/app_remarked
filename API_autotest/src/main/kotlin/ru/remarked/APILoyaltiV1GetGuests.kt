package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APILoyaltiV1GetGuests {
    fun getLoyaltiV1(): Response {
        val loyaltyToken = System.getenv("LOYALTY_API_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/api",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
   "jsonrpc":"2.0",
   "method":"LoyaltyV1API.GetGuest",
   "params":{
       "token":"$loyaltyToken",
       "card_number":"12345678",
       "id":12345678
   },
   "id":"6535665565467465"
}
"""
        )
    }
}
