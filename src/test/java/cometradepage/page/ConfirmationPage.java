package cometradepage.page;

import cometradepage.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationPage extends BaseTest {

    public ConfirmationPage() {

        PageFactory.initElements(driver,this);
    }

    @FindBy (css = ".alert-success")
    WebElement alertSuccess;


    public boolean alertSuccessDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(alertSuccess));
        return alertSuccess.isDisplayed();
    }
    public String alertSuccessAssert() {
        wdWait.until(ExpectedConditions.visibilityOf(alertSuccess));
        return alertSuccess.getText();
    }
}