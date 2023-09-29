package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIGetDaysStates {
    fun getDaysStates() : Response {
        val reserveToken = System.getenv("RESERVES_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
   "method": "GetDaysStates",
   "token": "$reserveToken",
   "reserve_date_period": {
       "from":"2023-03-21",
       "to":"2023-03-21"
   },
   "guests_count": "2"
}"""

        )
    }

    fun getDaysStatesWrongToken() : Response {
        val reserveToken = System.getenv("RESERVES_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
   "method": "GetDaysStates",
   "token": "random incorrect token",
   "reserve_date_period": {
       "from":"2023-03-21",
       "to":"2023-03-21"
   },
   "guests_count": "2"
}"""

        )
    }

    fun getDaysStateWrongTimePeriod() : Response {
        val reserveToken = System.getenv("RESERVES_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
   "method": "GetDaysStates",
   "token": "$reserveToken",
   "reserve_date_period": {
       "from":"2023-03-22",
       "to":"2023-03-21"
   },
   "guests_count": "2"
}"""

        )

    }
}
