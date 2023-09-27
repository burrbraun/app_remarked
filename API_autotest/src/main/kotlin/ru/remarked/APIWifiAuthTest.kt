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
    fun APIToCheckInvalidTokenWifiAuth(postTime:String): Response {
        val curTime = LocalDateTime.now().toLocalTime()
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiGuestWifi",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{"token": "ed783cb5-fa76-4b03-928c-a5409bac4a", "phonenumber": "test $curTime", "date": "$postTime"}"""
        )
    }
    fun APIToCheckInvalidDateFormatWifiAuth(postTime:String): Response {
        val curTime = LocalDateTime.now().toLocalTime()
        val wifiAuthToken = System.getenv("WIFI_AUTH_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiGuestWifi",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{"token": "$wifiAuthToken", "phonenumber": "test $curTime", "date": "9999941243"}"""
        )
    }
}
