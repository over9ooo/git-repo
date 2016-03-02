package my.supercompany;


import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class GoogleTest extends BaseTest {

    GooglePage page = new GooglePage(driver);

    @Test
    public void testSearchText() {
        page.visit();

        page.searchMore("selenium");
        assertThat(textToBePresentInElement(page.firstResult, "Selenium is a suite of tools to automate web browsers"));

        page.searchMore(" chemical element");
        assertThat(textToBePresentInElement(page.firstResult, "Selenium is a chemical element"));
    }

}