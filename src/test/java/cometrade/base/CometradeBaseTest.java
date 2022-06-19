package cometrade.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CometradeBaseTest {

    public static WebDriver driver;
    public static WebDriverWait wdWait;
    public JavascriptExecutor js;
    public static Actions actions;

    @Before

    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //ChromeDriver constructor method that makes an object
        //new key word that allocates memory
        wdWait = new WebDriverWait(driver, 30);
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        driver.manage().window().maximize();
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
    @After
    public void tearDown () {

        driver.quit();
    }
}
