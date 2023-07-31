package ru.remarked

import java.time.LocalDate
import java.time.LocalDateTime
import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIReserveCreate {
    fun createReserve(reservePostTime:String): Response {
        //val reservePostTime = LocalDate.now()
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """ {
    "method": "CreateReserve",
    "token": "ada53d2ce8463941bb9b844f1df9be49",
    "reserve": {
        "name": "TestClient",
        "phone": "+79999999922",
        "email": "test@mail.ru",
        "date": "$reservePostTime",
        "time": "13:30",
        "guests_count": 4,
       "utm": "utm_source=google",
       "deposit_sum": 500.00,
       "deposit_status": "paid",
       "comment": "test",
      "duration": 120,
  "tables":[
	11220,
	12910
  ]
    },
    "request_id": "23214314314132"
}
"""
        )
    }
}
