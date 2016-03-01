package my.supercompany;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class BaseTest extends ConciseAPI {

    static WebDriver driver = new FirefoxDriver();

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
