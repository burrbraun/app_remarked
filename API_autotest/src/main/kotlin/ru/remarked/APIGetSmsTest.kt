package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIGetSmsTest {
    fun getSMSVerificationTest(): Response {
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{"method": "GetSMSCode","token": "ada53d2ce8463941bb9b844f1df9be49","phone": "+7 (999) 979-79-79","request_id": "12345687654321"}"""
        )

    }
}
