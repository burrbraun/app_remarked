package whatsapp

import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIWhatsappMediaGetImageTest {
    fun whatsAppGetImage(): Response {
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/api",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{
  "method": "WhatsappMediaApi.GetImage",
  "jsonrpc": "2.0",
  "params": { 
       "token": "9cacff45-b085-4971-ad10-f5630f48b9dd", 
       "filename": "20230801152505-79516537928-3EB0AFB6B5E87E36DAE259.jpeg"
  },
   "id": "32434124134"
}"""
        )
    }
}
