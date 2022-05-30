package cometradepage.test;

import cometradepage.base.BaseTest;
import cometradepage.page.ConfirmationPage;
import cometradepage.page.RegistrationPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegistrationTests extends BaseTest {
    RegistrationPage registrationPage;
    ConfirmationPage confirmationPage;
    //tip promenljive i ime promenljive
//    Pošto ne možemo da nasledimo Page klasu, nama trebaju njene metode.
//    Kako bismo ih koristili napravicemo od njih objekte
    @Before
    public void setUpTest() throws InterruptedException {
        //staticki polimorfizam radi po principu moguce je imati dve metode istog naziva koje operisu na različitim tipovima promenljivih
        // dinamicki polimorfizam, pregazili smo metodu i napravili smo novu, overajdovali smo je, kad se zovu isto.
        //@Before metode ne smeju da se zovu isto, zbog dinamičkog polimorfizma.
        registrationPage = new RegistrationPage();
        confirmationPage = new ConfirmationPage();
        Thread.sleep(10000);
        //WebElement popUpButton = (WebElement) js.executeScript("return document.querySelector('#popup-smart-root-35743').shadowRoot.querySelector('#PsCloseButton')");
        //popUpButton.click();
//        WebElement popUpButtonOne = (WebElement) js.executeScript("return document.querySelector('#popup-smart-root-35986').shadowRoot.querySelector('#PsCloseButton')");
//        popUpButtonOne.click();
//        WebElement popUpButtonTwo = (WebElement) js.executeScript("return document.querySelector('#popup-smart-root-35018').shadowRoot.querySelector('#PsCloseButton')");
//        popUpButtonTwo.click();
       // WebElement popUpButtonThree = (WebElement) js.executeScript("return document.querySelector('#popup-smart-root-35848').shadowRoot.querySelector('#PsCloseButton')");
       // popUpButtonThree.click();
//        WebElement popUpButtonFour = (WebElement) js.executeScript("return document.querySelector('#popup-smart-root-36444').shadowRoot.querySelector('#PsCloseButton')");
//      popUpButtonFour.click();
//        WebElement popUpButtonFive = (WebElement) js.executeScript("return document.querySelector('#popup-smart-root-36499').shadowRoot.querySelector('#PsCloseButton')");
//        popUpButtonFive.click();
    }

    /**
     * This test case will log in to the Cometrade shop as a user.
       * After successful login there will be displayed alert, "Thank you for registering.
       * Please check your email and activate your account."
       * Additional item: performance testing with @CashLookup and for loops.
      */

    @Test
    public void successfulRegistrationTest() {

        System.setProperty("webdriver.chrome.logfile", "TestLog.txt");
        registrationPage.prihvatamButtonClick();
        long withCacheStartTime = System.currentTimeMillis();
        for(int i = 0; i < 500; i ++)
        {
            registrationPage.imeInputFieldSendKeys("Testko");
        }
        long withCacheEndTime = System.currentTimeMillis();
        System.out.println("Time take in seconds With cache " + ((withCacheEndTime - withCacheStartTime)/ 500));
        long withoutCacheStartTime = System.currentTimeMillis();
        for(int i = 0; i < 500; i ++)
        {
            registrationPage.prezimeInputFieldSendKeys("Maric");
        }
        long withoutCacheEndTime = System.currentTimeMillis();
        System.out.println("Time take in seconds Without cache " + ((withoutCacheEndTime - withoutCacheStartTime)/ 500));
        registrationPage.emailInputFieldSendKeys("dolmebokne@vusras.com");
        registrationPage.newsLetterCheckboxSelect();
        registrationPage.sifraInputFieldSendKeys("123456s");
        registrationPage.potvrdaSifreInputFieldSendKeys("123456s");
        registrationPage.posaljiButtonClick();
        String alertSuccess = confirmationPage.alertSuccessAssert();
        //every statement like this, are actually two calls
        // @FindBy to find the element and getText to get the text.
        Assert.assertEquals("Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog.", alertSuccess);
        Assert.assertTrue(confirmationPage.alertSuccessDisplayed());
    }

    /**This test case will log in as legal entity,
     *  with two different passwords
     * Assert an alert about unsuccessful registration
     */

    @Test
    public void comtradeRegistrationLegalEntityTest() {

        registrationPage.prihvatamButtonClick();
        registrationPage.imeInputFieldSendKeys("Isabella");
        registrationPage.prezimeInputFieldSendKeys("Volanti");
        registrationPage.emailInputFieldSendKeys("sdgsdshdsd@dsdd.com");
        registrationPage.newsLetterCheckboxSelect();
        registrationPage.pravnoLiceDropdownSelect(1);
        registrationPage.firmaInputFieldSendKeys("IsabellaTech");
        registrationPage.pibInputFieldSendKeys("123456789");
        String sifra = registrationPage.sifraInputFieldSendKeys("dshdsjdhsj");
        String potvrda = registrationPage.potvrdaSifreInputFieldSendKeys("54dsds4");
        registrationPage.posaljiButtonClick();
        Assert.assertEquals(sifra, potvrda);
        Assert.assertTrue(registrationPage.alertWarningDisplayed());
 }

     /** This test case will log in with sam mail adress
      * After login  there will be displayed alert,
      * "Već postoji nalog sa unetom email adresom! Molimo ulogujte se!"
      * Assert an alert about successful registration
      */
 @Test
    public void sameMailadressTest() {
       registrationPage.prihvatamButtonClick();
       registrationPage.imeInputFieldSendKeys("Sara");
       registrationPage.prezimeInputFieldSendKeys("Cometrade");
       registrationPage.emailInputFieldSendKeys("dolmebokne@vusras.com");
       registrationPage.newsLetterCheckboxSelect();
       registrationPage.sifraInputFieldSendKeys("Jdkslkd8");
       registrationPage.potvrdaSifreInputFieldSendKeys("Jdkslkd8");
       registrationPage.posaljiButtonClick();
       String alertWarning = registrationPage.alertWarningAssert();
       Assert.assertEquals("Već postoji nalog sa unetom email adresom! Molimo ulogujte se!",alertWarning);
       Assert.assertTrue(registrationPage.alertWarningDisplayed());
 }

    /** Negative test case.
     *  Enter a nine-character pib
     */
 @Test

    public void pibNegativeTest() {

      registrationPage.prihvatamButtonClick();
      registrationPage.imeInputFieldSendKeys("Isabella");
      registrationPage.prezimeInputFieldSendKeys("Volanti");
      registrationPage.emailInputFieldSendKeys("sdcxchdsd@dsdd.com");
      registrationPage.newsLetterCheckboxSelect();
      registrationPage.pravnoLiceDropdownSelect(1);
      registrationPage.firmaInputFieldSendKeys("EllaTech");
      registrationPage.pibInputFieldSendKeys("Ajrpel*de");
      registrationPage.sifraInputFieldSendKeys("ddklsjdlsdjls");
      registrationPage.potvrdaSifreInputFieldSendKeys("ddklsjdlsdjls");
      registrationPage.posaljiButtonClick();
      String alertWarning = registrationPage.alertWarningAssert();
      Assert.assertEquals("PIB mora sadržati tačno 9 cifara!",alertWarning);
      Assert.assertTrue(registrationPage.alertWarningDisplayed());

 }


}
