package ru.remarked

import java.time.LocalDateTime
import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIWifiAuthTest {
    fun APIToCreateRecordInWifiAuthBase(postTime:String): Response {
        val curTime = LocalDateTime.now().toLocalTime()
        val wifiAuthToken = System.getenv("WIFI_AUTH_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiGuestWifi",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{"token": "$wifiAuthToken", "phonenumber": "test $curTime", "date": "$postTime"}"""
        )

    }
}
