package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIGetReservesByPhone {
    fun getReservesByPhoneNumber(reserveByPhone: String) : Response {
        val reservePhoneNumber = "+79999999999"
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
	"method":"GetReservesByPhone",
	"token":"ada53d2ce8463941bb9b844f1df9be49",
	"phone": "$reservePhoneNumber",
	"request_id": "23234345"
}"""

        )

    }
}
