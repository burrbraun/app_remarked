package ru.remarked

import java.time.LocalDate
import java.time.LocalDateTime
import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIReserveCreate {
    fun createReserve(reservePostTime:String): Response {
        //val reservePostTime = LocalDate.now()
        val reserveToken = System.getenv("RESERVES_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """ {
    "method": "CreateReserve",
    "token": "$reserveToken",
    "reserve": {
        "name": "TestClient",
        "phone": "+70000000000",
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
    fun createReserveForTheFixedTimeAndGuest(): Response {
        val reserveToken = System.getenv("RESERVES_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """ {
    "method": "CreateReserve",
    "token": "$reserveToken",
    "reserve": {
        "name": "TestClient",
        "phone": "+70000000000",
        "email": "test@mail.ru",
        "date": "2033-06-28",
        "time": "15:30:25",
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
""")}
    fun createReserveForTheSameTimeAndGuest(): Response {
        val reserveToken = System.getenv("RESERVES_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """ {
    "method": "CreateReserve",
    "token": "$reserveToken",
    "reserve": {
        "name": "TestClient",
        "phone": "+70000000000",
        "email": "test@mail.ru",
        "date": "2033-06-28",
        "time": "15:30:25",
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
""")

    }
}
