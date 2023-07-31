package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIGetDaysStates {
    fun getDaysStates() : Response {
        val token = "ada53d2ce8463941bb9b844f1df9be49"
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
   "method": "GetDaysStates",
   "token": "$token",
   "reserve_date_period": {
       "from":"2023-03-21",
       "to":"2023-03-21"
   },
   "guests_count": "2"
}"""

        )
    }
}
