package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIGetSlotsTest {
    fun getSlots(): Response {
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
   "method": "GetSlots",
   "token": "ada53d2ce8463941bb9b844f1df9be49",
   "reserve_date_period": {
       "from":"2023-03-01",
       "to":"2023-03-31"
   },
   "guests_count": "4"
}"""
        )
    }
}
