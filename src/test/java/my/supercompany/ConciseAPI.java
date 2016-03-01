package my.supercompany;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class ConciseAPI {

    public abstract WebDriver getWebDriver();

    public void open(String url) {
        getWebDriver().get(url);
    }

    public WebElement findElement(By locator) {
        return getWebDriver().findElement(locator);
    }

    public WebElement findElementByCssSelecotr(String locator) {
        return getWebDriver().findElement(By.cssSelector(locator));
    }

    public void assertThat(ExpectedCondition<Boolean> condition) {
        (new WebDriverWait(getWebDriver(), 4)).until(condition);
    }

}
