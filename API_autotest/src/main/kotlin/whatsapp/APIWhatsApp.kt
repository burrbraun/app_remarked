package whatsapp

import java.time.LocalDateTime
import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.response.Response

class APIWhatsApp {
    fun whatsAppSendMessages(textMessage:String): Response {
        val whatsAppToken = System.getenv("WHATSAPP_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/api",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{"method":"RemarkedWhatsappApi.SendMessage","jsonrpc":"2.0","params":{"token":"$whatsAppToken","phone":"+79516537928","local_phone":"+79516537928","message":"$textMessage"}}"""

        )
    }

    fun whatsAppIncorrectTokenMessagesSend(textMessage:String): Response {
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/api",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{"method":"RemarkedWhatsappApi.SendMessage","jsonrpc":"2.0","params":{"token":"1234567890","phone":"+79516537928","message":"$textMessage","num":"+79516537928"}}"""

        )
    }
    fun whatsAppIncorrectPhoneNumberMessageSend(textMessage: String):Response {
        val whatsAppToken = System.getenv("WHATSAPP_TOKEN")
        return OkNetwork.restClient().post(
            url = "https://app.remarked.ru/api/v1/api",
            headers = mutableMapOf(
                "Content-Type" to "application/json"
            ),
            body = """{"method":"RemarkedWhatsappApi.SendMessage","jsonrpc":"2.0","params":{"token":"$whatsAppToken","phone":"+7","message":"$textMessage","num":"+79516537928"}}"""
        )
    }
}
