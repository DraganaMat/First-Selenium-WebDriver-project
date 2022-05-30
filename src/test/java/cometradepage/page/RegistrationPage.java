package cometradepage.page;

import cometradepage.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BaseTest {
//    naziv klase uvek počinje velikim slovom
    public RegistrationPage() {
        //nema povratnu vrednost znaci da je konstruktor metoda
        //spakovali biblioteku pagefactory za pravljenje web elemenata, inicijalizuje sve web elemente locirane preko @FindBy
//        Page Factory will initialize every WebElement variable with a reference to a corresponding element on the actual web page based on “locators” defined.
//        This is done by using @FindBy annotations.
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="firstname")
    @CacheLookup
    WebElement imeInputField;
    @FindBy(id="lastname")
    WebElement prezimeInputField;
    @FindBy (id="is_subscribed")
    WebElement newsLetterCheckbox;
    @FindBy(css=".button.btn")
    @CacheLookup
    WebElement posaljiButton;
    @FindBy (id= "email_address")
    @CacheLookup
    WebElement emailInputField;
    @FindBy (id = "password")
    WebElement sifraInputField;
    @FindBy(id = "confirmation")
    WebElement potvrdaSifreInputField;
    @FindBy (xpath = "//button[text() = 'Prihvatam']")
    @CacheLookup
    WebElement prihvatamButton;
    @FindBy(id = "pravnolice")
    @CacheLookup
    WebElement pravnoLiceDropdown;
    @FindBy (id = "firma")
    @CacheLookup
    WebElement firmaInputField;
    @FindBy(id = "pib")
    @CacheLookup
    WebElement pibInputField;
    @FindBy(css = ".alert-warning")
    WebElement alertWarning;
    @FindBy (css= ".am-opener")
    WebElement sviProizvodi;
    @CacheLookup
    @FindBy (css = ".img-info.pos-9")
    WebElement belaTehnika;
    @FindBy (linkText = "Šporeti")
    WebElement sporeti;

    //repozitorijum svih veb elemenata

    //Defining all the user actions that can be performed in the loginPage
    //in the form of methods
    public void imeInputFieldSendKeys(String ime) {
        wdWait.until(ExpectedConditions.visibilityOf(imeInputField)).clear();
        imeInputField.sendKeys(ime);
        //metoda ce svaki put traziti neki string da joj se prosledi, potom ga upisuje u sendKeys
        // i mozemo je koristiti neogranicen broj puta.
    }
    public void prezimeInputFieldSendKeys (String prezime) {
        wdWait.until(ExpectedConditions.visibilityOf(prezimeInputField)).clear();
        prezimeInputField.sendKeys(prezime);
    }
    public void posaljiButtonClick () {

        wdWait.until(ExpectedConditions.elementToBeClickable(posaljiButton)).click();
    }
    public void newsLetterCheckboxSelect () {

       wdWait.until(ExpectedConditions.visibilityOf(newsLetterCheckbox));
       if (newsLetterCheckbox.isSelected()) {
           newsLetterCheckbox.click();
       }
    }
    public void emailInputFieldSendKeys (String email) {
        wdWait.until(ExpectedConditions.visibilityOf(emailInputField)).clear();
        emailInputField.sendKeys(email);
    }
    public String sifraInputFieldSendKeys (String sifra) {
        wdWait.until(ExpectedConditions.visibilityOf(sifraInputField)).clear();
        sifraInputField.sendKeys(sifra);
        return sifra;
    }

    public String potvrdaSifreInputFieldSendKeys (String potvrda) {
        wdWait.until(ExpectedConditions.visibilityOf(potvrdaSifreInputField)).clear();
        potvrdaSifreInputField.sendKeys(potvrda);
        return potvrda;
    }
    public void firmaInputFieldSendKeys (String firma) {
        wdWait.until(ExpectedConditions.visibilityOf(firmaInputField)).clear();
        firmaInputField.sendKeys(firma);
    }
    public void pibInputFieldSendKeys (String pib) {
        wdWait.until(ExpectedConditions.visibilityOf(pibInputField)).clear();
        pibInputField.sendKeys(pib);
    }
    public void prihvatamButtonClick () {
        wdWait.until(ExpectedConditions.elementToBeClickable(prihvatamButton)).click();
    }
    public void pravnoLiceDropdownSelect (int index) {
        wdWait.until(ExpectedConditions.visibilityOf(pravnoLiceDropdown));
        Select drop = new Select(pravnoLiceDropdown);
        drop.selectByIndex(index);
        //WebElement promenljiva i select promenljiva ne mogu imati isto ime
    }
    public boolean alertWarningDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(alertWarning));
        return alertWarning.isDisplayed();
    }
    public String alertWarningAssert () {
        wdWait.until(ExpectedConditions.visibilityOf(alertWarning));
        return alertWarning.getText();
    }
//    Hover test
    public void sviProizvodiHover () {
        wdWait.until(ExpectedConditions.visibilityOf(sviProizvodi));
        actions.moveToElement(sviProizvodi).perform();
    }
    public void belaTehnikaHover () {
        wdWait.until(ExpectedConditions.visibilityOf(belaTehnika));
        actions.moveToElement(belaTehnika).perform();
    }
    public void sporetiHover () {
        wdWait.until(ExpectedConditions.visibilityOf(sporeti));
        actions.moveToElement(sporeti).perform();
    }
    public void sporetiClick () {
        wdWait.until(ExpectedConditions.elementToBeClickable(sporeti)).click();
    }
}
