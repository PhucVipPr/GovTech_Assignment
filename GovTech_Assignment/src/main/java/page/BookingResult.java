package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingResult extends BasePage {

    public BookingResult(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='sc-jnqLxu dGXXPl']")
    private WebElement viewBookingBtn;

    public void toBookingDetail(){
        viewBookingBtn.click();
    }
}
