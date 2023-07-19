package ru.remarked

import java.time.LocalDateTime
import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIWifiAuthTest {
    fun APIToCreateRecordInWifiAuthBase(postTime:String): Response {
        val curTime = LocalDateTime.now().toLocalTime()
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiGuestWifi",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{"token": "ed783cb5-fa76-4b03-928c-a5409bac4a33", "phonenumber": "test $curTime", "date": "$postTime"}"""
        )

    }
}
