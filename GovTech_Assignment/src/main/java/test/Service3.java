package test;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;

import java.io.IOException;

public class Service3 extends BaseTest {

    @Test(dataProvider = "service3")
    public void TC03(String tcid, String requireVerifyBySA, String isSpAutoAssign, String showSlotEndTime,
                     String disableCancelBooking, String disableRescheduleBooking, String bookingStatus){
        PublicService publicService = new PublicService(getDriver());
        publicService.navigateToLoginPage("https://www.tst.bookingsg.io/public/services/wgyb9Qke/availability?");
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

        AcceptBooking acceptBooking = new AcceptBooking(getDriver());
        acceptBooking.toViewBooking();

        BookingResultDetail bookingResultDetail = new BookingResultDetail(getDriver());
        bookingResultDetail.verifyBookingResultService(tcid, bookingStatus, isSpAutoAssign, disableCancelBooking, disableRescheduleBooking);
    }

    @DataProvider(name = "service3")
    public Object[][] getTestData() throws IOException {
        return ExcelUtils.getTableArray("src/main/resources/TestResult.xlsx","Service3",0,7);
    }
}
