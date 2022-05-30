package halooglasi.page;

import halooglasi.base.HaloOglasiBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends HaloOglasiBaseTest {

     public LoginPage () {
         PageFactory.initElements(driver,this);
     }

    @FindBy (linkText = "Registrujte se")
    WebElement registrationLink;

     public void registrationLinkClick () {
         wdWait.until(ExpectedConditions.elementToBeClickable(registrationLink)).click();
     }










}
