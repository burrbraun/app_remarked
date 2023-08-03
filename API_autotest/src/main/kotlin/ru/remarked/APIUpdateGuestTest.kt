package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIUpdateGuestTest {
    fun updateGuest(): Response {
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/api",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
    "jsonrpc": "2.0",
    "id": 1234567890,
    "method": "GuestsApi.UpdateGuest",
    "params": {
        "token": "x1f65bb3b99200cd5a643cb88fe3d4bf",
        "id": "29445627",
        "fields": {"email": "test@test.ru"
        }
    }
}"""
        )
    }
}
