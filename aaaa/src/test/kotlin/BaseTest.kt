import java.time.LocalDateTime
import junit.framework.TestCase.assertEquals
import kotlinx.serialization.Serializable
import org.junit.Test
import ru.remarked.APIBookingTimeRequest
import ru.remarked.APIWifiWebHooks
import ru.talenttech.xqa.oknetwork.OkNetwork.restClient
import ru.talenttech.xqa.oknetwork.actions.Condition
import ru.talenttech.xqa.oknetwork.actions.shouldBe
import whatsapp.APIWhatsApp

class BaseTest {
    @Test
    fun testGetPetId() {
        restClient().get(
            url = "https://petstore.swagger.io/v2/pet/3",
            headers = mutableMapOf(
            "accept" to "application/json"
        )
        ).shouldBe(Condition.codeEquals(200),
            Condition.bodyParamEquals("status","available")
        )

    }

    @Test
    fun createPet() {
        restClient().post(
            url = "https://petstore.swagger.io/v2/pet",
            headers = mutableMapOf(
                "accept" to "application/json",
                "Content-Type" to "application/json"
            ),
            body = """{
   "id":1373737,
   "category":{
      "id":13,
      "name":"string"
   },
   "name":"Boggie",
   "photoUrls":[
      "string"
   ],
   "tags":[
      {
         "id":12,
         "name":"string"
      }
   ],
   "status":"available"
}"""
        ).shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("id", 1373737),
            Condition.headerValueEquals("content-type", "application/json")
        )
    }
    @Test
    fun getTime() {
        val timesRequest = APIBookingTimeRequest()
        val request = timesRequest.timesRequest("2021-10-28")
        request.shouldBe(Condition.codeEquals(200))
        val requestBody:List<Int> = request.body("times.timestamp")
        assertEquals(1635400800,requestBody[0])
    }
    @Test
    fun wifiAuthPost() {
        val wifiAuth = APIWifiWebHooks()
        val request = wifiAuth.APIWifiAuthPost("2023-05-13 00:00:00")
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("status","OK")
        )

    }
    @Test
    fun whatsappMessageSend() {
        val whatsAppSend = APIWhatsApp()
        val now = LocalDateTime.now()
        val request = whatsAppSend.whatsAppSendMessages("test from idea '$now'")
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("result.status","ok"),
            Condition.bodyParamEquals("result.data.success", true)
        )
    }
}

