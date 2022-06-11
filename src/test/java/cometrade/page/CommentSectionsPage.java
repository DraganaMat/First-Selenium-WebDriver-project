package cometrade.page;

import cometrade.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommentSectionsPage extends BaseTest {
    public CommentSectionsPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy (linkText = "Ocene")
    WebElement ocene;
    @FindBy (xpath = "//*[contains(text(), 'EKONOMICAN')]")
    WebElement ekonomicanNaslov;
    @FindBy (xpath = "//*[contains(text(), '(28.11.2018)')]")
    WebElement datumKomentara;
    @FindBy (xpath = "//*[contains(text(), 'Odluka o kupovini ovog sporeta je izmedju ostalog doneta zbog nase velike potrosnje struje, sada nam plinske ringle u tome mnogo pomazu. Rerna je dovoljno velika i za gostinsko spremanje a gril koristim u kombinaciji sa konvencionalnim pecenjem. Ciscenje rerne je prava pesma obzirom da ima Steam Shine program. Sve u svemu PUN POGODAK!')]")
    WebElement tekstKomentara;
    @FindBy (xpath = "//*[contains(text(), 'Zorica')]")
    WebElement zoricaKomentar;



    public void oceneFocus() {
        wdWait.until(ExpectedConditions.visibilityOf(ocene));
        actions.moveToElement(ocene).perform();
    }
    public void oceneClick () {
        wdWait.until(ExpectedConditions.elementToBeClickable(ocene)).click();

    }
    public boolean ekonomicanNaslovDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(ekonomicanNaslov));
        return ekonomicanNaslov.isDisplayed();
    }
    public String ekonomicanNaslovAssert () {
        wdWait.until(ExpectedConditions.visibilityOf(ekonomicanNaslov));
        return ekonomicanNaslov.getText();
    }
    public boolean datumKomentaraDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(datumKomentara));
        return datumKomentara.isDisplayed();
    }
    public String datumKomentaraAssert () {
        wdWait.until(ExpectedConditions.visibilityOf(datumKomentara));
        return datumKomentara.getText();
    }
    public boolean tekstKomentaraDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(tekstKomentara));
        return tekstKomentara.isDisplayed();
    }
    public String tekstKomentaraAssert () {
        wdWait.until(ExpectedConditions.visibilityOf(tekstKomentara));
        return tekstKomentara.getText();
    }
    public boolean zoricaKomentarDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(zoricaKomentar));
        return zoricaKomentar.isDisplayed();
    }
    public String zoricaKomentarAssert () {
        wdWait.until(ExpectedConditions.visibilityOf(zoricaKomentar));
        return zoricaKomentar.getText();
    }


}
