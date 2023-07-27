import java.time.LocalDateTime
import junit.framework.TestCase.assertEquals
import kotlinx.serialization.Serializable
import org.junit.Test
import ru.remarked.APIBookingTimeRequest
import ru.remarked.APIGetReserveByID
import ru.remarked.APIGetSmsTest
import ru.remarked.APIWifiAuthTest
import ru.remarked.APIWifiWebHooks
import ru.talenttech.xqa.oknetwork.OkNetwork.restClient
import ru.talenttech.xqa.oknetwork.actions.Condition
import ru.talenttech.xqa.oknetwork.actions.shouldBe
import whatsapp.APIWhatsApp

class BaseTest {
     @Test
     fun getTime() {
         val timesRequest = APIBookingTimeRequest()
         val request = timesRequest.timesRequest("2021-10-28")
         request.shouldBe(Condition.codeEquals(200))
         val requestBody:List<Int> = request.body("times.timestamp")
         assertEquals(1635400800,requestBody[0])
     }
    @Test
    fun whatsappMessageSend() {
        val whatsAppSend = APIWhatsApp()
        val now = LocalDateTime.now()
        val request = whatsAppSend.whatsAppSendMessages("test from Jenkins '$now'")
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
    // @Test //тест в любом случае 200-тит и присылает ошибку
    // fun getSMSCodeTest() {
    //     val apiGetSmsTest = APIGetSmsTest()
    //     val request = apiGetSmsTest.getSMSVerificationTest()
    //     request.shouldBe(
    //     Condition.codeEquals(200)
    //     )
    // }
    @Test
    fun getReserveInfoById(){
        val apiGetReserveByID = APIGetReserveByID()
        val request = apiGetReserveByID.getReserveInfoById("3190378")
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("reserve.surname","тестова")
        )
    }
}

