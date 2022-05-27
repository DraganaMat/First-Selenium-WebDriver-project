package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    public static WebDriver driver;
    // static znaci da njemu moze da se pristupa bez pravljenja objekta te klase,
    // kljucna rec koja govori programu da ovu rec mozemo zvati bez pravljenja objekta ove klase
    public static WebDriverWait wdWait;
    public JavascriptExecutor js;
    public static Actions actions;

    @Before

    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //ChromeDriver je konstruktor metoda koja pravi objekat
        // new metoda ključna rec koja rezervise memoriju
        wdWait = new WebDriverWait(driver, 30);
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://www.ctshop.rs/customer/account/create");
        Thread.sleep(20000);
//        WebElement popUpButtonOne = (WebElement) js.executeScript("return document.querySelector('#popup-smart-root-35986').shadowRoot.querySelector('#PsCloseButton')");
//        popUpButtonOne.click();
        //WebElement popUpButton = (WebElement) js.executeScript("return document.querySelector('#popup-smart-root-35018').shadowRoot.querySelector('#PsCloseButton')");
        //popUpButton.click();
    }
    @After
    public void tearDown () {

        driver.quit();
    }
}
