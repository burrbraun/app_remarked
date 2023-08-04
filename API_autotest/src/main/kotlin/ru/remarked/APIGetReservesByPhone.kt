package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIGetReservesByPhone {
    fun getReservesByPhoneNumber(reserveByPhone: String) : Response {
        val reservePhoneNumber = "+79999999999"
        val reserveToken = System.getenv("RESERVES_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
	"method":"GetReservesByPhone",
	"token":"$reserveToken",
	"phone": "$reservePhoneNumber",
	"request_id": "23234345"
}"""

        )

    }
}
