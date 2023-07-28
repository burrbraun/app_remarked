package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIGetListOfTImesAndTablesForNumOfGuests {
    fun getListOfTimesANdTablesForNumOfGuests(textMessage:String): Response {
        val method = "GetTimesWithTablesPeriod"
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
	"method": "$method",
	"token": "ada53d2ce8463941bb9b844f1df9be49",
	"request_id":  "2132314",
	"reserve_date_period":
{
    	"from": "2023-07-28",
    	"to": "2023-07-28"
	},
	"guests_count": "5000"
}"""

        )
    }
}
