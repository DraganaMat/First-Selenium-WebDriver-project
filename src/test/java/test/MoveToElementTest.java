package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.*;

public class MoveToElementTest extends BaseTest {
    RegistrationPage registrationPage;
    KombinovaniSporetiPage kombinovaniSporetiPage;
    FilteriPage filteriPage;
    ZoricaKomentarPage zoricaKomentarPage;
    BekoFSS54010DWPage bekoFSS54010DWPage;
    GorenjeK5111SGPage gorenjeK5111SGPage;

    @Before
     public void SetsUpTest () throws InterruptedException {

        registrationPage = new RegistrationPage();
        kombinovaniSporetiPage = new KombinovaniSporetiPage();
        filteriPage = new FilteriPage();
        zoricaKomentarPage = new ZoricaKomentarPage();
        bekoFSS54010DWPage = new BekoFSS54010DWPage();
        gorenjeK5111SGPage = new GorenjeK5111SGPage();
        Thread.sleep(15000);
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

    @Test

    public void moveToElementTest () {
        registrationPage.prihvatamButtonClick();
        registrationPage.sviProizvodiHover();
        registrationPage.belaTehnikaHover();
        registrationPage.sporetiHover();
        registrationPage.sporetiClick();
        registrationPage.prihvatamButtonClick();
        kombinovaniSporetiPage.kombinovaniSporetiFocus();
        kombinovaniSporetiPage.kombinovaniSporetiClick();
        filteriPage.filterGorenjeHover();
        filteriPage.filterGorenjeClick();
        filteriPage.sporetGorenjeHover();
        filteriPage.sporetGorenjeClick();
        Assert.assertTrue(gorenjeK5111SGPage.bojaAparataDisplayed());
        String bojaAparata = gorenjeK5111SGPage.bojaAparataAssert();
        Assert.assertEquals("Boja aparata: Siva metalik", bojaAparata);
        driver.navigate().back();
        filteriPage.ponistiFiltereClick();
        filteriPage.filterBekoFocus();
        filteriPage.filterBekoClick();
        filteriPage.sporetBekoFocus();
        filteriPage.sporetBekoClick();
        Assert.assertTrue(bekoFSS54010DWPage.cenaPopustDisplayed());
        String popust = bekoFSS54010DWPage.cenaPopustAssert();
        Assert.assertEquals("25.579", popust);
        zoricaKomentarPage.oceneFocus();
        zoricaKomentarPage.oceneClick();
        Assert.assertTrue(zoricaKomentarPage.ekonomicanNaslovDisplayed());
        Assert.assertEquals("EKONOMICAN", zoricaKomentarPage.ekonomicanNaslovAssert());
        Assert.assertTrue(zoricaKomentarPage.datumKomentaraDisplayed());
        Assert.assertEquals("(28.11.2018)", zoricaKomentarPage.datumKomentaraAssert());
        Assert.assertTrue(zoricaKomentarPage.tekstKomentaraDisplayed());
        Assert.assertEquals("Odluka o kupovini ovog sporeta je izmedju ostalog doneta zbog nase velike potrosnje struje, sada nam plinske ringle u tome mnogo pomazu. Rerna je dovoljno velika i za gostinsko spremanje a gril koristim u kombinaciji sa konvencionalnim pecenjem. Ciscenje rerne je prava pesma obzirom da ima Steam Shine program. Sve u svemu PUN POGODAK!", zoricaKomentarPage.tekstKomentaraAssert());
        Assert.assertTrue(zoricaKomentarPage.zoricaKomentarDisplayed());
        Assert.assertEquals("Zorica", zoricaKomentarPage.zoricaKomentarAssert());

    }



}
