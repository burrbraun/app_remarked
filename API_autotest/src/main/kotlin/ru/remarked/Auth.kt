package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class Auth {
    fun getToken() : Response {
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/ApiReservesWidget",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{"method":"GetToken", "point":"7999999"}""")
    }
}
