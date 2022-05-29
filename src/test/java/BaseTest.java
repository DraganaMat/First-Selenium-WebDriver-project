import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {

    //Declaration of variable driver which starts Chrome
    public static WebDriver driver;
    JavascriptExecutor js;
    //Declaration of Wait variable
    public static WebDriverWait wdWait;
    public static Actions actions;

    //This is JUnit anonotation, always runs before the execution of each test case
    @Before
    //This is a method that we write arbitrarily and put everything that needs to be done BEFORE all the tests

    public void setUp() throws InterruptedException {
        //This automatically downloads the corresponding version of the driver
        WebDriverManager.chromedriver().setup();
        //Creating an object of ChromeDriver
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver, 30);
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        driver.manage().window().maximize();
        //to navigate to a particular URL
        driver.get("https://www.ctshop.rs/customer/account/create");
         Thread.sleep(20000);
        WebElement popUpButton = (WebElement) js.executeScript("return document.querySelector('#popup-smart-root-35743').shadowRoot.querySelector('#PsCloseButton')");
        WebElement popUpButtonOne = (WebElement) js.executeScript("return document.querySelector('#popup-smart-root-35986').shadowRoot.querySelector('#PsCloseButton')");
        WebElement popUpButtonTwo = (WebElement) js.executeScript("return document.querySelector('#popup-smart-root-35018').shadowRoot.querySelector('#PsCloseButton')");
        WebElement popUpButtonThree = (WebElement) js.executeScript("return document.querySelector('#popup-smart-root-35848').shadowRoot.querySelector('#PsCloseButton')");
        if (popUpButton.isDisplayed()) {

            popUpButton.click();
        }
        else if (popUpButtonOne.isDisplayed()) {

            popUpButtonOne.click();
        }
        else if (popUpButtonTwo.isDisplayed()){

            popUpButtonTwo.click();

        } else if (popUpButtonThree.isDisplayed()) {

            popUpButtonThree.click();

        }

    }

    //This is a Junit annotation, this method will be performed after all the tests
    @After
    //
    public void tearDown() {

        driver.close();
    }

    //This is a method whose name we give arbitrarily and that's where we put all the test steps

    @Test
    public void firstTest() {

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("Beograd");
        driver.findElement(By.linkText("Gmail")).click();
    }

    @Test
    public void comtradeSuccessfulRegistrationTest() {
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']")));
        driver.findElement(By.xpath("//button[text() = 'Prihvatam']")).click();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).clear();
        driver.findElement(By.id("firstname")).sendKeys("Gale");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname"))).clear();
        driver.findElement(By.id("lastname")).sendKeys("Mat");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address"))).clear();
        driver.findElement(By.id("email_address")).sendKeys("folmebokne@vusras.com");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("is_subscribed")));
        if (driver.findElement(By.id("is_subscribed")).isSelected()) {
            driver.findElement(By.id("is_subscribed")).click();
        }
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).clear();
        driver.findElement(By.id("password")).sendKeys("123456");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation"))).clear();
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Pošalji')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Pošalji')]")).click();

    }

    @Test
    public void selectSeleniumExampleTest() {

        driver.get("https://www.ctshop.rs/customer/account/create");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pravnolice")));
        Select pravnolice = new Select(driver.findElement(By.id("pravnolice")));
        pravnolice.selectByVisibleText("Da");
        // pravnolice.selectByValue("1");
        //pravnolice.selectByIndex(1);
    }

    @Test

    public void comtradeRegistrationLegalEntity() {

        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).clear();
        driver.findElement(By.id("firstname")).sendKeys("Isabella");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname"))).clear();
        driver.findElement(By.id("lastname")).sendKeys("Volanti");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address"))).clear();
        driver.findElement(By.id("email_address")).sendKeys("folmebokne@vusro.com");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("is_subscribed")));
        if (driver.findElement(By.id("is_subscribed")).isSelected()) {
            driver.findElement(By.id("is_subscribed")).click();
        }
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pravnolice")));
        Select pravnolice = new Select(driver.findElement(By.id("pravnolice")));
        pravnolice.selectByVisibleText("Da");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firma"))).clear();
        driver.findElement(By.id("firma")).sendKeys("Isabella Tech");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pib"))).clear();
        driver.findElement(By.id("pib")).sendKeys("123456789");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).clear();
        driver.findElement(By.id("password")).sendKeys("Anajd56#");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation"))).clear();
        driver.findElement(By.id("confirmation")).sendKeys("Hjjdls9");

        String ActualPassword = "Anajd56#";
        String ExpectedPassword = "Hjjdls9";
        Assert.assertNotEquals(ExpectedPassword, ActualPassword);

        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Pošalji')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Pošalji')]")).click();

    }
    @Test

    public void comtradeRegistrationLegalEntitySuccess () {

        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).clear();
        driver.findElement(By.id("firstname")).sendKeys("Isabella");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname"))).clear();
        driver.findElement(By.id("lastname")).sendKeys("Volanti");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address"))).clear();
        driver.findElement(By.id("email_address")).sendKeys("folmeokne@vusro.com");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("is_subscribed")));
        if (driver.findElement(By.id("is_subscribed")).isSelected()) {
            driver.findElement(By.id("is_subscribed")).click();
        }
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pravnolice")));
        Select pravnolice = new Select(driver.findElement(By.id("pravnolice")));
        pravnolice.selectByVisibleText("Da");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firma"))).clear();
        driver.findElement(By.id("firma")).sendKeys("Isabella Tech");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pib"))).clear();
        driver.findElement(By.id("pib")).sendKeys("123456789");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).clear();
        driver.findElement(By.id("password")).sendKeys("Anajd56#");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation"))).clear();
        driver.findElement(By.id("confirmation")).sendKeys("Anajd56#");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Pošalji')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Pošalji')]")).click();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert-success")));
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success")).isDisplayed());
        Assert.assertEquals("Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog", driver.findElement(By.cssSelector(".alert-success")).getText());

    }
 @Test

    public void smederevacSporet () throws InterruptedException {

   //Action method is declared in Base class and is initialized in @Before
   wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();
   wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".am-opener")));
   actions.moveToElement(driver.findElement(By.cssSelector(".am-opener"))).perform();
   wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".img-info.pos-9")));
   actions.moveToElement(driver.findElement(By.cssSelector(".img-info.pos-9"))).perform();
   actions.moveToElement(driver.findElement(By.linkText("Šporeti"))).perform();
   wdWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Šporeti"))).click();
   wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();
   actions.moveToElement(driver.findElement(By.xpath("//span[text()='Kombinovani šporeti']"))).perform();
   wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Kombinovani šporeti']"))).click();
   actions.moveToElement(driver.findElement(By.xpath("//label[text()='Gorenje']"))).perform();
   wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Gorenje']"))).click();
   js.executeScript("window.scrollBy(0,1000)");
   actions.moveToElement(driver.findElement(By.xpath("//a[starts-with(@title, 'K5111SG')]"))).perform();
   wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[starts-with(@title, 'K5111SG')]"))).click();
   wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(), 'Boja aparata')]")));
   Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Boja aparata')]")).isDisplayed());
   Assert.assertEquals("Boja aparata: Siva metalik",
   driver.findElement(By.xpath("//p[contains(text(), 'Boja aparata')]")).getText());
   driver.navigate().back();
   wdWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Poništi sve filtere"))).click();
   actions.moveToElement(driver.findElement(By.xpath("//label[text()='Beko']"))).perform();
   wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Beko']"))).click();
   js.executeScript("window.scrollBy(0,1000)");
   actions.moveToElement(driver.findElement(By.xpath("//a[starts-with(@title,'FSS54010DW')]"))).perform();
   wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[starts-with(@title,'FSS54010DW')]"))).click();
   wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'extra-discount-price pull-left')]/span")));
   Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'extra-discount-price pull-left')]/span")).isDisplayed());
   Assert.assertEquals("25.579",
   driver.findElement(By.xpath("//div[contains(@class,'extra-discount-price pull-left')]/span")).getText());
   actions.moveToElement(driver.findElement(By.linkText("Ocene"))).perform();
   wdWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Ocene"))).click();
   js.executeScript("window.scrollBy(0,900)");
   wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'EKONOMICAN')]")));
   Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'EKONOMICAN')]")).isDisplayed());
   Assert.assertEquals(("EKONOMICAN"),
   driver.findElement(By.xpath("//*[contains(text(), 'EKONOMICAN')]")).getText());
   wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '(28.11.2018)')]")));
   Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), '(28.11.2018)')]")).isDisplayed());
   Assert.assertEquals(("(28.11.2018)"),
   driver.findElement(By.xpath("//*[contains(text(), '(28.11.2018)')]")).getText());
   wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Odluka o kupovini ovog sporeta je izmedju ostalog doneta zbog nase velike potrosnje struje, sada nam plinske ringle u tome mnogo pomazu. Rerna je dovoljno velika i za gostinsko spremanje a gril koristim u kombinaciji sa konvencionalnim pecenjem. Ciscenje rerne je prava pesma obzirom da ima Steam Shine program. Sve u svemu PUN POGODAK!')]")));
   Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Odluka o kupovini ovog sporeta je izmedju ostalog doneta zbog nase velike potrosnje struje, sada nam plinske ringle u tome mnogo pomazu. Rerna je dovoljno velika i za gostinsko spremanje a gril koristim u kombinaciji sa konvencionalnim pecenjem. Ciscenje rerne je prava pesma obzirom da ima Steam Shine program. Sve u svemu PUN POGODAK!')]")).isDisplayed());
   Assert.assertEquals(("Odluka o kupovini ovog sporeta je izmedju ostalog doneta zbog nase velike potrosnje struje, sada nam plinske ringle u tome mnogo pomazu. Rerna je dovoljno velika i za gostinsko spremanje a gril koristim u kombinaciji sa konvencionalnim pecenjem. Ciscenje rerne je prava pesma obzirom da ima Steam Shine program. Sve u svemu PUN POGODAK!"),
   driver.findElement(By.xpath("//*[contains(text(), 'Odluka o kupovini ovog sporeta je izmedju ostalog doneta zbog nase velike potrosnje struje, sada nam plinske ringle u tome mnogo pomazu. Rerna je dovoljno velika i za gostinsko spremanje a gril koristim u kombinaciji sa konvencionalnim pecenjem. Ciscenje rerne je prava pesma obzirom da ima Steam Shine program. Sve u svemu PUN POGODAK!')]")).getText());
   wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//*[contains(text(), 'Zorica')]"))));
   Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Zorica')]")).isDisplayed());
   Assert.assertEquals(("Zorica"),
   driver.findElement(By.xpath("//*[contains(text(), 'Zorica')]")).getText());

 }
  @Test

    public void sameMailAdress () {

      wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).clear();
      driver.findElement(By.id("firstname")).sendKeys("Gale");
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname"))).clear();
      driver.findElement(By.id("lastname")).sendKeys("Mat");
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address"))).clear();
      driver.findElement(By.id("email_address")).sendKeys("folmebokne@vusras.com");
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("is_subscribed")));
      if (driver.findElement(By.id("is_subscribed")).isSelected()) {
          driver.findElement(By.id("is_subscribed")).click();
      }
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).clear();
      driver.findElement(By.id("password")).sendKeys("123456");
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation"))).clear();
      driver.findElement(By.id("confirmation")).sendKeys("123456");
      wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Pošalji')]"))).click();
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert-warning")));
      Assert.assertTrue(driver.findElement(By.cssSelector(".alert-warning")).isDisplayed());
      Assert.assertEquals("Već postoji nalog sa unetom email adresom! Molimo ulogujte se!",
              driver.findElement(By.cssSelector(".alert-warning")).getText());
      Assert.assertTrue(driver.findElements(By.cssSelector(".alert-success")).isEmpty());
  }

  @Test

    public void pibNegativeTest () {
      wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).clear();
      driver.findElement(By.id("firstname")).sendKeys("Isabella");
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname"))).clear();
      driver.findElement(By.id("lastname")).sendKeys("Volanti");
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address"))).clear();
      driver.findElement(By.id("email_address")).sendKeys("folmebokne@vusro.com");
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("is_subscribed")));
      if (driver.findElement(By.id("is_subscribed")).isSelected()) {
          driver.findElement(By.id("is_subscribed")).click();
      }
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pravnolice")));
      Select pravnolice = new Select(driver.findElement(By.id("pravnolice")));
      pravnolice.selectByVisibleText("Da");
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firma"))).clear();
      driver.findElement(By.id("firma")).sendKeys("Isabella Tech");
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pib"))).clear();
      driver.findElement(By.id("pib")).sendKeys("HJHJHKhj*");
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).clear();
      driver.findElement(By.id("password")).sendKeys("Rtjd56#");
      wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation"))).clear();
      driver.findElement(By.id("confirmation")).sendKeys("Rtjd56#");
      wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Pošalji')]")));
      driver.findElement(By.xpath("//span[contains(text(),'Pošalji')]")).click();
      Assert.assertTrue(driver.findElement(By.cssSelector(".alert-warning")).isDisplayed());
      Assert.assertEquals(("PIB mora sadržati tačno 9 cifara!"),
              driver.findElement(By.cssSelector(".alert-warning")).getText());
  }

     // This is the end of the class.
     // Nothing can be written after curly brackets.
     //There is no test without assert.

    }


