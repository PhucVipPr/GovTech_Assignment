package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AcceptBooking extends BasePage {

    public AcceptBooking(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "view-bookings")
    private WebElement viewBooking;

    public void toViewBooking(){
        viewBooking.click();
    }
}
