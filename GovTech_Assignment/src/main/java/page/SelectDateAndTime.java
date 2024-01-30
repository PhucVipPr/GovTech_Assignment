package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class SelectDateAndTime extends BasePage {

    public SelectDateAndTime(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='sc-gKfoOY eVbVwc']/div[@class='sc-jDnxRY khoyFO']")
    private List<WebElement> calendarDate;

    @FindBy(xpath = "//div[@class='sgds-card-content']")
    private List<WebElement> bookingTimeSlot;

    @FindBy(xpath = "//h4[@class='sc-kcuKUB sc-bIlkxI gEfhLj cEygpJ']")
    private WebElement bookingTime;

    @FindBy(xpath = "//button[@class='sc-jnqLxu dGXXPl sc-ldNgDf bpzPkz']")
    private WebElement confirmBtn;

    public void selectBookingDate() {
        LocalDate localDate = LocalDate.now();
        int currentDate = localDate.getDayOfMonth();
        for (WebElement dateElement : calendarDate) {
            int date = Integer.parseInt(dateElement.getText());
            if (date == currentDate) {
                dateElement.click();
                break;
            }
        }
    }

    public void selectBookingTime(){
        Random random = new Random();
        int index = random.nextInt(bookingTimeSlot.size());
        WebElement bookingTimeSelect = bookingTimeSlot.get(index);
        bookingTimeSelect.click();
    }

    public String verifyShowSlotEndTime(){
        String bookingTimeText = bookingTime.getText();
        if (bookingTimeText.contains("from")){
            return "true";
        }else if (bookingTimeText.contains("at")){
            return "false";
        }
        return null;
    }

    public void confirmBtn(){
        confirmBtn.click();
    }

}
