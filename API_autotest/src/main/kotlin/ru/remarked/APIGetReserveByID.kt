package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIGetReserveByID {
    fun getReserveInfoById(): Response {
        val reserveID = "3190378"
        val reserveToken = System.getenv("RESERVES_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
   "method": "GetReserveByID",
   "token": "$reserveToken",
   "reserve_id": $reserveID,
   "request_id": 3123141241242
}"""

        )
    }
}
