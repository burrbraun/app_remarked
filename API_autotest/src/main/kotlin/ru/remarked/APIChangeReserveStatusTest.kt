package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIChangeReserveStatusTest {
    fun changeReserveStatus(): Response {
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
    "method": "ChangeReserveStatus",
    "token": "ada53d2ce8463941bb9b844f1df9be49",
    "reserve_id": "3246291",
    "status": "confirmed",
    "request_id": "5467486758"
}"""
        )
    }

    fun changeReserveStatusToClose():Response {
        val reserveToken = System.getenv("RESERVES_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
    "method": "ChangeReserveStatus",
    "token": "$reserveToken",
    "reserve_id": "3246291",
    "status": "closed",
    "request_id": "5467486758"
}"""
        )
    }
}
