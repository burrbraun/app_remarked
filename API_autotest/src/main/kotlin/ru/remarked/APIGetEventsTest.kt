package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIGetEventsTest {
    fun getEvents(): Response {
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
   "method": "GetEventTags",
   "token": "ada53d2ce8463941bb9b844f1df9be49"
}"""
        )
    }
}
