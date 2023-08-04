package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIBookingTimeRequest {
    fun timesRequest(dataTime:String): Response {
        val reserveToken = System.getenv("RESERVES_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{"method":"GetTimes","token":"$reserveToken","reserve_date":"$dataTime","guests_count":"2"}"""
        )
    }
}
