package cometrade.test;

import cometrade.base.CometradeBaseTest;
import cometrade.page.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoveToElementTestCometrade extends CometradeBaseTest {
    RegistrationPage registrationPage;
    KombinovaniSporetiPage kombinovaniSporetiPage;
    FilterPage filterPage;
    CommentSectionsPage commentSectionsPage;
    BekoFSS54010DWPage bekoFSS54010DWPage;
    GorenjeK5111SGPage gorenjeK5111SGPage;

    @Before
     public void SetsUpTest () throws InterruptedException {

        registrationPage = new RegistrationPage();
        kombinovaniSporetiPage = new KombinovaniSporetiPage();
        filterPage = new FilterPage();
        commentSectionsPage = new CommentSectionsPage();
        bekoFSS54010DWPage = new BekoFSS54010DWPage();
        gorenjeK5111SGPage = new GorenjeK5111SGPage();

    }

    /** Ovaj Test Case će hoverovati preko "Svi proizvodi", potom "Bela tehnika" pa na "šporete".
     *  Zatim će kliknuti na kombinovane šporete, izabrati Gorenje filter, izabrati Gorenje šporet,
     *  asertovati boju šporeta, potom se vratiti nazad poništiti sve filtere
     * izabrati Beko filter, izabrati Beko šporet, proveriti da je cena na popustu
     * i potom proveriti ceo komentar koji je ostavila Zorica (datum, naslov, tekst komentara).
     */


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
        filterPage.filterGorenjeHover();
        filterPage.filterGorenjeClick();
        filterPage.sporetGorenjeHover();
        filterPage.sporetGorenjeClick();
        Assert.assertTrue(gorenjeK5111SGPage.bojaAparataDisplayed());
        String bojaAparata = gorenjeK5111SGPage.bojaAparataAssert();
        Assert.assertEquals("Boja aparata: Siva metalik", bojaAparata);
        driver.navigate().back();
        filterPage.ponistiFiltereClick();
        filterPage.filterBekoFocus();
        filterPage.filterBekoClick();
        filterPage.sporetBekoFocus();
        filterPage.sporetBekoClick();
        Assert.assertTrue(bekoFSS54010DWPage.cenaPopustDisplayed());
        String popust = bekoFSS54010DWPage.cenaPopustAssert();
        Assert.assertEquals("25.579", popust);
        commentSectionsPage.oceneFocus();
        commentSectionsPage.oceneClick();
        Assert.assertTrue(commentSectionsPage.ekonomicanNaslovDisplayed());
        Assert.assertEquals("EKONOMICAN", commentSectionsPage.ekonomicanNaslovAssert());
        Assert.assertTrue(commentSectionsPage.datumKomentaraDisplayed());
        Assert.assertEquals("(28.11.2018)", commentSectionsPage.datumKomentaraAssert());
        Assert.assertTrue(commentSectionsPage.tekstKomentaraDisplayed());
        Assert.assertEquals("Odluka o kupovini ovog sporeta je izmedju ostalog doneta zbog nase velike potrosnje struje, sada nam plinske ringle u tome mnogo pomazu. Rerna je dovoljno velika i za gostinsko spremanje a gril koristim u kombinaciji sa konvencionalnim pecenjem. Ciscenje rerne je prava pesma obzirom da ima Steam Shine program. Sve u svemu PUN POGODAK!", commentSectionsPage.tekstKomentaraAssert());
        Assert.assertTrue(commentSectionsPage.zoricaKomentarDisplayed());
        Assert.assertEquals("Zorica", commentSectionsPage.zoricaKomentarAssert());

    }


}
