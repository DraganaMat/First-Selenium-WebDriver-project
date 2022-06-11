package cometrade.page;

import cometrade.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FilterPage extends BaseTest {
    public FilterPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//label[text()='Gorenje']")
    WebElement filterGorenje;
    @FindBy (xpath = "//a[starts-with(@title, 'K5111SG')]")
    WebElement sporetGorenje;
    @FindBy (linkText = "Poništi sve filtere")
    WebElement ponistiFiltere;
    @FindBy (xpath = "//label[text()='Beko']")
    WebElement filterBeko;
    @FindBy (xpath = "//a[starts-with(@title,'FSS54010DW')]")
    WebElement sporetBeko;

    public void filterGorenjeHover () {
        wdWait.until(ExpectedConditions.visibilityOf(filterGorenje));
        actions.moveToElement(filterGorenje).perform();
    }
    public void filterGorenjeClick () {

        wdWait.until(ExpectedConditions.elementToBeClickable(filterGorenje)).click();
    }
    public void sporetGorenjeHover () {
        wdWait.until(ExpectedConditions.visibilityOf(sporetGorenje));
        actions.moveToElement(sporetGorenje).perform();
    }
    public void sporetGorenjeClick () {

        wdWait.until(ExpectedConditions.elementToBeClickable(sporetGorenje)).click();
    }
    public void ponistiFiltereClick () {
        wdWait.until(ExpectedConditions.elementToBeClickable(ponistiFiltere)).click();
    }
    public void filterBekoFocus () {
        wdWait.until(ExpectedConditions.visibilityOf(filterBeko));
        actions.moveToElement(filterBeko).perform();
    }
    public void filterBekoClick () {

        wdWait.until(ExpectedConditions.elementToBeClickable(filterBeko)).click();
    }
    public void sporetBekoFocus () {
        wdWait.until(ExpectedConditions.visibilityOf(sporetBeko));
        actions.moveToElement(sporetBeko).perform();
    }
    public void sporetBekoClick () {
        wdWait.until(ExpectedConditions.elementToBeClickable(sporetBeko)).click();
    }
}
