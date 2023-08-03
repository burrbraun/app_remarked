package ru.remarked

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIZumaReviewsCreateTest {
    fun createReview(): Response {
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/api",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
   "method": "ZumaReviewsApi.CreateReview",
   "jsonrpc": "2.0",
   "params": {
       "token": "22e9b8cc87097bbd24e69d95b8c6bc7f",
       "fields": {
           "date": "22-08-01 12:12:12",
           "author": "Matroskin the cat",
           "source": "afisha.ru",
           "rating": "2",
           "textReview": "Неправильно ты, дядя Федор, бутерброд ешь"
       }
   },
   "id": 131114241124
}"""
        )
    }
}
