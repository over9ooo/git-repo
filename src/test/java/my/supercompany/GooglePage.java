package my.supercompany;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GooglePage extends BasePage {

    @FindBy(css = ".srg .g:nth-child(1)")
    public WebElement firstResult;

    public void visit() {
        open("https://www.google.com/ncr");
    }

    public void searchMore(String text) {
        findElement(By.name("q")).sendKeys(text, Keys.ENTER);
    }

    public GooglePage(WebDriver driver) {
        super(driver);
    }

}