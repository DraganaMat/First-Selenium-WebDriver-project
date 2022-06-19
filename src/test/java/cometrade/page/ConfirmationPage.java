package cometrade.page;

import cometrade.base.CometradeBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationPage extends CometradeBaseTest {

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
