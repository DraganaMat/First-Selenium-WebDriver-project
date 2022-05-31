package halooglasi.page;

import halooglasi.base.HaloOglasiBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends HaloOglasiBaseTest {

    public RegistrationPage () {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//input[contains(@value,'person')]")
    WebElement fizickoLiceChecked;

    @FindBy (id = "UserName")
    WebElement userNameInputField;

    @FindBy (id = "Email")
    WebElement emailInputField;

    @FindBy (id ="Password")
    WebElement passwordInputField;

    @FindBy (id ="ConfirmPassword")
    WebElement confirmationPasswordInputField;




   public void fizickoLiceSelected () {
        wdWait.until(ExpectedConditions.visibilityOf(fizickoLiceChecked));
        if (fizickoLiceChecked.isSelected()) {
            fizickoLiceChecked.click();
       }
   }




}
