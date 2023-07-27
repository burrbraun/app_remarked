package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIGetReserveByID {
    fun getReserveInfoById(textMessage:String): Response {
        val reserveID = "3190378"
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
   "method": "GetReserveByID",
   "token": "ada53d2ce8463941bb9b844f1df9be49",
   "reserve_id": $reserveID,
   "request_id": 3123141241242
}"""

        )
    }
}
