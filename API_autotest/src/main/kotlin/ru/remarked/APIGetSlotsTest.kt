package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIGetSlotsTest {
    fun getSlots(): Response {
        val reserveToken = System.getenv("RESERVES_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
   "method": "GetSlots",
   "token": "$reserveToken",
   "reserve_date_period": {
       "from":"2023-03-01",
       "to":"2023-03-31"
   },
   "guests_count": "4"
}"""
        )
    }
}
