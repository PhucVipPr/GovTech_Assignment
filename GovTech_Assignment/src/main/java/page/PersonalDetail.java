package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalDetail extends BasePage {

    public PersonalDetail(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='sc-jnqLxu dGXXPl sc-ldNgDf bpzPkz']")
    private WebElement nextBtn;

    public void nextBtnClick(){
        getWait().until(ExpectedConditions.visibilityOf(nextBtn));
        nextBtn.click();
    }

}
