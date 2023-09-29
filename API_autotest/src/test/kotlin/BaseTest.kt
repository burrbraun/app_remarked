import java.time.LocalDate
import java.time.LocalDateTime
import junit.framework.TestCase.assertEquals
import org.junit.Test
import ru.remarked.APIBookingTimeRequest
import ru.remarked.APIChangeReserveStatusTest
import ru.remarked.APIGetDaysStates
import ru.remarked.APIGetEventsTest
import ru.remarked.APIGetGuestsData
import ru.remarked.APIGetListOfTImesAndTablesForNumOfGuests
import ru.remarked.APIGetReserveByID
import ru.remarked.APIGetReservesByPhone
import ru.remarked.APIGetReservesToken
import ru.remarked.APIGetSlotsTest
import ru.remarked.APIGetSmsTest
import ru.remarked.APILoyaltiV1GetGuests
import ru.remarked.APIReserveCreate
import ru.remarked.APIUpdateGuestTest
import ru.remarked.APIWifiAuthTest
import ru.remarked.APIZumaReviewsCreateTest
import ru.talenttech.xqa.oknetwork.actions.Condition
import ru.talenttech.xqa.oknetwork.actions.shouldBe
import whatsapp.APIWhatsApp
import whatsapp.APIWhatsappMediaGetImageTest
//import io.qameta.allure.AllureId

class BaseTest {
     @Test
     //@AllureId("167")
     fun getTime() {
         val timesRequest = APIBookingTimeRequest()
         val request = timesRequest.timesRequest("2021-10-28")
         request.shouldBe(Condition.codeEquals(200))
         val requestBody:List<Int> = request.body("times.timestamp")
         assertEquals(1635400800,requestBody[0])
     }
    @Test
    //@AllureId("166")
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
    fun whatsappMessageWrongTokenSend() {
        val whatsAppSend = APIWhatsApp()
        val now = LocalDateTime.now()
        val request = whatsAppSend.whatsAppIncorrectTokenMessagesSend("test from Jenkins '$now'")
        request.shouldBe(
            Condition.codeEquals(401),
            Condition.bodyParamEquals("error.message", "Unauthorized")
        )
    }
    @Test
    fun whatsAppWrongNumberMessageSend() {
        val whatsAppSend = APIWhatsApp()
        val now = LocalDateTime.now()
        val request = whatsAppSend.whatsAppIncorrectPhoneNumberMessageSend("test from Jenkins '$now'")
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("result.status","ok"),
            Condition.bodyParamEquals("result.data.error", true)
        )
    }

    @Test
    fun whatsAppIncorrectTokenTest() {
        val apiWhatsApp = APIWhatsApp()
        val now = LocalDateTime.now()
        val request = apiWhatsApp.whatsAppIncorrectTokenMessagesSend("test from Jenkins '$now'")
        request.shouldBe(
            Condition.codeEquals(401),
            Condition.bodyParamEquals("error.message","Unauthorized")
        )
    }
    @Test
    //@AllureId("168")
    fun getWhatsappImage(){
        val apiWhatsappMediaGetImageTest = APIWhatsappMediaGetImageTest()
        val request = apiWhatsappMediaGetImageTest.whatsAppGetImage()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("result.media_info.mime","image/jpeg"),
            Condition.bodyParamEquals("result.success", true)
        )
    }

    @Test
    //@AllureId("169") //тест создает новую запись в отчете вай фай авторизаций по телефону
    fun wifiAuthNewLinePost() {
        val apiWifiAuthTest = APIWifiAuthTest()
        val postTime = LocalDateTime.now().minusHours(24)
        val request = apiWifiAuthTest.APIToCreateRecordInWifiAuthBase("$postTime")
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("status","OK")
        )
    }

    @Test
    fun wifiAuthInvalidTokenResponseCheck() {
        val apiWifiAuthTest = APIWifiAuthTest()
        val postTime = LocalDateTime.now().minusHours(24)
        val request = apiWifiAuthTest.APIToCheckInvalidTokenWifiAuth("$postTime")
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("status","error"),
            Condition.bodyParamEquals("message", "invalid token")
        )
    }
     @Test //тест в любом случае 200-тит и присылает ошибку
     fun getSMSCodeTest() {
         val apiGetSmsTest = APIGetSmsTest()
         val request = apiGetSmsTest.getSMSVerificationTest()
         request.shouldBe(
         Condition.codeEquals(200)
         )
     }
    @Test
    //@AllureId("170")
    fun getReserveInfoById(){
        val apiGetReserveByID = APIGetReserveByID()
        val request = apiGetReserveByID.getReserveInfoById()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("reserve.surname","тестова")
        )
    }
    @Test
   // @AllureId("171")
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
    fun createSameReserveInSystem() {
        val apiReserveCreate = APIReserveCreate()
        val request = apiReserveCreate.createReserveForTheFixedTimeAndGuest()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("status", "error")
        )
        val requestAgain = apiReserveCreate.createReserveForTheSameTimeAndGuest()
        requestAgain.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("message","This Guests Has Already Reserved Place At This Date")
        )
    }
    @Test
    //@AllureId("172")
    fun getReservesByPhoneNumber() {
        val apiGetReservesByPhone = APIGetReservesByPhone()
        val request = apiGetReservesByPhone.getReservesByPhoneNumber("+70000000000")
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("limit", 100)
        )
    }
    @Test
   // @AllureId("173")
    fun changeReserveStatus(){
        val apiChangeReserveStatusTest = APIChangeReserveStatusTest()
        val request = apiChangeReserveStatusTest.changeReserveStatus()
        val requestAgain = apiChangeReserveStatusTest.changeReserveStatusToClose()
        requestAgain.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("status", "success")
        )
    }

    @Test
    //@AllureId("174")
    fun getListOfTimesAndTablesForNumOfGuests() {
        val apiGetListOfTimesAndTablesForNumOfGuests = APIGetListOfTImesAndTablesForNumOfGuests()
        val request = apiGetListOfTimesAndTablesForNumOfGuests.getListOfTimesANdTablesForNumOfGuests("GetTimesWithTablesPeriod")
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("rooms.307396.name", "Второй зал")
        )
    }
    @Test
   // @AllureId("175")
    fun getReservesTokenForApi(){
        val apiGetReservesToken = APIGetReservesToken()
        val request = apiGetReservesToken.getReservesAPIToken()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("token", "ada53d2ce8463941bb9b844f1df9be49")
        )
    }
    @Test
   // @AllureId("176")
    fun getDaysStateApi() {
        val apiGetDaysStates = APIGetDaysStates()
        val request = apiGetDaysStates.getDaysStates()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("status", "success")
        )
    }

    @Test
    fun getDaysStateApiWrongToken() {
        val apiGetDaysStates = APIGetDaysStates()
        val request = apiGetDaysStates.getDaysStatesWrongToken()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("status", "error")
        )
    }

    @Test
    fun getDaysStateApiWrongDaysPeriod() {
        val apiGetDaysStates = APIGetDaysStates()
        val request = apiGetDaysStates.getDaysStateWrongTimePeriod()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("status", "error")
        )
    }

    @Test
   // @AllureId("177")
    fun getGuestsDataById() {
        val apiGetGuestsData = APIGetGuestsData()
        val request = apiGetGuestsData.getGuestsDataById()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("result.41057243.fio", "Jenkins TestBot")
        )
    }
    @Test
   // @AllureId("178")
    fun getGuestsDataByPhone() {
        val apiGetGuestsData = APIGetGuestsData()
        val request = apiGetGuestsData.getGuestsDataByPhone()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("result.41057243.fio", "Jenkins TestBot")
        )
    }
    @Test
   // @AllureId("179")
    fun APIGetSlots() {
        val apiGetSlotsTest = APIGetSlotsTest()
        val request = apiGetSlotsTest.getSlots()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("status", "success")
        )
    }
    @Test
   // @AllureId("180")
    fun APIGetEvents() {
        val apiGetEventsTest = APIGetEventsTest()
        val request = apiGetEventsTest.getEvents()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("status", "success")
        )
    }
    @Test
   // @AllureId("181")
    fun APICreateReview(){
        val apiZumaReviewsCreateTest = APIZumaReviewsCreateTest ()
        val request = apiZumaReviewsCreateTest.createReview()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("result.status", "ok")
        )
    }
    @Test
   // @AllureId("182")
    fun updateGuest() {
        val apiUpdateGuestTest = APIUpdateGuestTest()
        val request = apiUpdateGuestTest.updateGuest()
        request.shouldBe(
            Condition.codeEquals(200),
            Condition.bodyParamEquals("result.status", "ok")
        )
    }
    @Test
   // @AllureId("183") //на текущий момент (2 августа 2023) проверка идет номинальная по коду ответа сервера - 200 - ок
    fun getGuestsLoyaltiV1() {
        val apiLoyaltiV1GetGuests = APILoyaltiV1GetGuests()
        val request = apiLoyaltiV1GetGuests.getLoyaltiV1()
        request.shouldBe(
            Condition.codeEquals(200)
        )
    }
}

