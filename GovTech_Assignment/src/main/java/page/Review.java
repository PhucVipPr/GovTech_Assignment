package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Review extends BasePage {

    public Review(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='sc-jnqLxu dGXXPl sc-ldNgDf bpzPkz']")
    private WebElement submitBtn;

    public void submitBtnClick(){
        getWait().until(ExpectedConditions.visibilityOf(submitBtn));
        submitBtn.click();
    }
}
