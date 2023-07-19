package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIWifiWebHooks {
    fun APIWifiAuthPost(dataTime:String): Response {
        return OkNetwork.restClient().post(
        url = "https://app.remarked.ru/api/v1/ApiGuestWifi",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
        ),
            body = """{"phonenumber":"+055555555","token":"","date":"$dataTime"}"""
        )
    }
}
