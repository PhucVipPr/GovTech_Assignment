package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookingResultDetail extends BasePage {

    public BookingResultDetail(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='sc-dHbHSM gxxGda']")
    private WebElement bookingStatus;

    @FindBy(xpath = "//tbody[@class='sc-daSpeN aBIwr']/tr/td[4]")
    private WebElement serviceProvider;

    @FindBy(xpath = "//div[@class='sc-ciyJVK hFieab']/button[1]")
    private WebElement rescheduleBtn;

    @FindBy(xpath = "//div[@class='sc-ciyJVK hFieab']/button[2]")
    private WebElement cancelBtn;

    public void verifyBookingResultService(String tcid, String eBookingStatus, String isSpAutoAssign,
                                           String disableCancelBooking, String disableRescheduleBooking){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(tcid);

        if (matcher.find()) {
            String numberStr = matcher.group();
            int serviceNumber = Integer.parseInt(numberStr);
            boolean isRescheduleBtnEnabled = rescheduleBtn.isEnabled();
            boolean isCancelBtnEnabled = cancelBtn.isEnabled();
            Assert.assertEquals(bookingStatus.getText(), eBookingStatus);
            String actualReschedule = "";
            String actualCancel = "";

            switch (serviceNumber) {
                case 1:
                    Assert.assertEquals(isSpAutoAssign, String.valueOf(serviceProvider.isDisplayed()));
                    Assert.assertFalse(isRescheduleBtnEnabled);
                    Assert.assertFalse(isCancelBtnEnabled);
                    break;
                case 2:
                    Assert.assertNotEquals(String.valueOf(serviceProvider.isDisplayed()), isSpAutoAssign);;
                    Assert.assertFalse(isRescheduleBtnEnabled);
                    Assert.assertFalse(isCancelBtnEnabled);
                    break;
                case 3:
                    Assert.assertEquals(isSpAutoAssign, String.valueOf(serviceProvider.isDisplayed()));
                    Assert.assertTrue(isRescheduleBtnEnabled);
                    Assert.assertFalse(isCancelBtnEnabled);
                    break;
                case 4:
                    Assert.assertNotEquals(String.valueOf(serviceProvider.isDisplayed()), isSpAutoAssign);;
                    Assert.assertFalse(isRescheduleBtnEnabled);
                    Assert.assertFalse(isCancelBtnEnabled);
                    break;
                case 5:
                    Assert.assertEquals(isSpAutoAssign, String.valueOf(serviceProvider.isDisplayed()));
                    Assert.assertFalse(isRescheduleBtnEnabled);
                    Assert.assertTrue(isCancelBtnEnabled);
                    break;
                case 6:
                    Assert.assertNotEquals(String.valueOf(serviceProvider.isDisplayed()), isSpAutoAssign);;
                    Assert.assertFalse(isRescheduleBtnEnabled);
                    Assert.assertFalse(isCancelBtnEnabled);
                    break;
            }
            actualReschedule = Boolean.toString(!isRescheduleBtnEnabled);
            actualCancel = Boolean.toString(!isCancelBtnEnabled);
            Assert.assertEquals(disableRescheduleBooking, actualReschedule);
            Assert.assertEquals(disableCancelBooking, actualCancel);
        }
    }
}
