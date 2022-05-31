package halooglasi.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HaloOglasiBaseTest {
    public static WebDriver driver;
    JavascriptExecutor js;
    public static WebDriverWait wdWait;
    public static Actions actions;


    @Before

    public void setUp() throws InterruptedException {
        //This automatically downloads the corresponding version of the driver
        WebDriverManager.chromedriver().setup();
        //Creating an object of ChromeDriver
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver, 30);
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://www.halooglasi.com/");
    }

    @After

    public void tearDown () {

        driver.quit();
    }


}
