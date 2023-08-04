package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIGetGuestsData {
    fun getGuestsDataById(): Response {
        val guestsToken = System.getenv("GUESTS_API_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/api",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
                "jsonrpc": "2.0",
    "id": 1234567890,
    "method": "GuestsApi.GetGuestsData",
    "params":
    {"token": "$guestsToken",
    "id": "29445627"
    }
}"""
        )
    }
    fun getGuestsDataByPhone(): Response{
        val guestsToken = System.getenv("GUESTS_API_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/api",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
                "jsonrpc": "2.0",
    "id": 7806087,
    "method": "GuestsApi.GetGuestsData",
    "params":
    {"token": "$guestsToken",
    "phone": "+71234567890"
    }
}"""
        )
    }
}
