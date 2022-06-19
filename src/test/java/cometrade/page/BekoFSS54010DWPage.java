package cometrade.page;

import cometrade.base.CometradeBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BekoFSS54010DWPage extends CometradeBaseTest {
    public BekoFSS54010DWPage() {

        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//div[contains(@class,'extra-discount-price pull-left')]/span")
    WebElement cenaPopust;

    public boolean cenaPopustDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(cenaPopust));
        return cenaPopust.isDisplayed();
    }
    public String cenaPopustAssert () {
        wdWait.until(ExpectedConditions.visibilityOf(cenaPopust));
        return cenaPopust.getText();
    }
}
