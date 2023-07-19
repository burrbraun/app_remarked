import java.time.LocalDateTime
import junit.framework.TestCase.assertEquals
import kotlinx.serialization.Serializable
import org.junit.Test
import ru.remarked.APIBookingTimeRequest
import ru.remarked.APIWifiAuthTest
import ru.remarked.APIWifiWebHooks
import ru.talenttech.xqa.oknetwork.OkNetwork.restClient
import ru.talenttech.xqa.oknetwork.actions.Condition
import ru.talenttech.xqa.oknetwork.actions.shouldBe
import whatsapp.APIWhatsApp

class BaseTest {
    // @Test
    // fun getTime() {
    //     val timesRequest = APIBookingTimeRequest()
    //     val request = timesRequest.timesRequest("2021-10-28")
    //     request.shouldBe(Condition.codeEquals(200))
    //     val requestBody:List<Int> = request.body("times.timestamp")
    //     assertEquals(1635400800,requestBody[0])
    // }
    // @Test
    // fun wifiAuthPost() {
    //     val wifiAuth = APIWifiWebHooks()
    //     val request = wifiAuth.APIWifiAuthPost("2023-05-13 00:00:00")
    //     request.shouldBe(
    //         Condition.codeEquals(200),
    //         Condition.bodyParamEquals("status","OK")
    //     )
    //
    // }
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
    @Test
    fun wifiAuthNewLinePost() {
        val apiWifiAuthTest = APIWifiAuthTest()
        val postTime = LocalDateTime.now().minusHours(24)
        val request = apiWifiAuthTest.APIToCreateRecordInWifiAuthBase("$postTime")
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("status","OK")
        )
    }
}

