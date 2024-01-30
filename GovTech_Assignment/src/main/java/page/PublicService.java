package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PublicService extends BasePage {

    public PublicService(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submit_btn")
    private WebElement mockConsentBtn;

    public void navigateToLoginPage(String url){
        getDriver().get(url);
    }

    public void login(){
        mockConsentBtn.click();
    }

}
