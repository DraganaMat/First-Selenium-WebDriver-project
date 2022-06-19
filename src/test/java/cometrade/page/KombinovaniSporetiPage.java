package cometrade.page;

import cometrade.base.CometradeBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KombinovaniSporetiPage extends CometradeBaseTest {
    public KombinovaniSporetiPage () {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//span[text()='Kombinovani šporeti']")
    WebElement kombinovaniSporeti;


    public void kombinovaniSporetiFocus () {
        wdWait.until(ExpectedConditions.visibilityOf(kombinovaniSporeti));
        actions.moveToElement(kombinovaniSporeti).perform();
    }
    public void kombinovaniSporetiClick () {
        wdWait.until(ExpectedConditions.elementToBeClickable(kombinovaniSporeti)).click();
    }


}
