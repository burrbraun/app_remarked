import java.time.LocalDate
import java.time.LocalDateTime
import junit.framework.TestCase.assertEquals
import org.junit.Test
import ru.remarked.APIBookingTimeRequest
import ru.remarked.APIGetDaysStates
import ru.remarked.APIGetListOfTImesAndTablesForNumOfGuests
import ru.remarked.APIGetReserveByID
import ru.remarked.APIGetReservesByPhone
import ru.remarked.APIGetReservesToken
import ru.remarked.APIReserveCreate
import ru.remarked.APIWifiAuthTest
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
        val request = apiGetReserveByID.getReserveInfoById()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("reserve.surname","тестова")
        )
    }
    @Test
    fun createReserveInSystem(){
        val apiReserveCreate = APIReserveCreate()
        val reservePostTime = LocalDate.now().plusDays(1)
        val request = apiReserveCreate.createReserve("$reservePostTime")
        val requestAgain = apiReserveCreate.createReserve("$reservePostTime")
        requestAgain.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("message","This Guests Has Already Reserved Place At This Date")
        )
    }
    @Test
    fun getReservesByPhoneNumber() {
        val apiGetReservesByPhone = APIGetReservesByPhone()
        val request = apiGetReservesByPhone.getReservesByPhoneNumber("+79999999999")
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("limit", 100)
        )
    }
    @Test
    fun getListOfTimesAndTablesForNumOfGuests() {
        val apiGetListOfTimesAndTablesForNumOfGuests = APIGetListOfTImesAndTablesForNumOfGuests()
        val request = apiGetListOfTimesAndTablesForNumOfGuests.getListOfTimesANdTablesForNumOfGuests("GetTimesWithTablesPeriod")
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("rooms.307396.name", "Второй зал")
        )
    }
    @Test
    fun getReservesTokenForApi(){
        val apiGetReservesToken = APIGetReservesToken()
        val request = apiGetReservesToken.getReservesAPIToken()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("token", "ada53d2ce8463941bb9b844f1df9be49")
        )
    }
    @Test
    fun getDaysStateApi() {
        val apiGetDaysStates = APIGetDaysStates()
        val request = apiGetDaysStates.getDaysStates()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("status", "success")

        )
    }

}

