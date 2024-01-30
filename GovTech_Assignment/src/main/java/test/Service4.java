package test;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;

import java.io.IOException;

public class Service4 extends BaseTest {

    @Test(dataProvider = "service4")
    public void TC04(String tcid, String requireVerifyBySA, String isSpAutoAssign, String showSlotEndTime,
                     String disableCancelBooking, String disableRescheduleBooking, String bookingStatus){
        PublicService publicService = new PublicService(getDriver());
        publicService.navigateToLoginPage("https://www.tst.bookingsg.io/public/services/8ayQDNko/availability?");
        publicService.login();

        SelectDateAndTime dateAndTime = new SelectDateAndTime(getDriver());
        dateAndTime.selectBookingDate();
        dateAndTime.selectBookingTime();
        Assert.assertEquals(dateAndTime.verifyShowSlotEndTime(), showSlotEndTime);
        dateAndTime.confirmBtn();

        PersonalDetail personalDetail = new PersonalDetail(getDriver());
        personalDetail.nextBtnClick();

        Review review = new Review(getDriver());
        review.submitBtnClick();

        BookingResult bookingResult = new BookingResult(getDriver());
        bookingResult.toBookingDetail();

        BookingResultDetail bookingResultDetail = new BookingResultDetail(getDriver());
        bookingResultDetail.verifyBookingResultService(tcid ,bookingStatus, isSpAutoAssign, disableCancelBooking, disableRescheduleBooking);
    }

    @DataProvider(name = "service4")
    public Object[][] getTestData() throws IOException {
        return ExcelUtils.getTableArray("src/main/resources/TestResult.xlsx","Service4",0,7);
    }
}
