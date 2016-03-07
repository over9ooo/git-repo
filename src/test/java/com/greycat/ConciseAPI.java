package com.greycat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.present;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ConciseAPI {

    //------------------------------ELEMENT LOCATORS------------------------------

    String lastTaskOnList = ".//li[last()]/div[@class='view']/label";

    String amountOfActiveTasks = ".//footer/span/strong";

    String firstTaskOnList = ".//li[1]/div[@class='view']/label";

    int totalAmountOfTasks = $$(".view label").size();

    //-----------------------------------ACTIONS-----------------------------------

    public void addNewTodo(String newTodoText) {
        $(".new-todo").setValue(newTodoText).pressEnter();
    }

    public void editTask(String N, String newText) {
        $(By.xpath(".//li[" + N + "]/div[@class='view']/label")).doubleClick();
        selectAllText($(By.xpath(".//li[" + N + "]/input")));
        $(By.xpath(".//li[" + N + "]/input")).sendKeys(newText, Keys.ENTER);
    }

    public void completeTask(String N) {
        $(By.xpath(".//li[" + N + "]/div[@class='view']/input")).click();
    }

    public void completeTheLastTask() {
        $(By.xpath(".//li[last()]/div[@class='view']/input")).click();
    }

    public void completeAllTasks() {
        $(By.xpath(".//section/input")).click();
    }

    public void showAllTasks() {
        $(By.xpath(".//footer/ul/li[1]/a")).click();
    }

    public void showActiveTasks() {
        $(By.xpath(".//footer/ul/li[2]/a")).click();
    }

    public void showCompletedTasks() {
        $(By.xpath(".//footer/ul/li[3]/a")).click();
    }

    public void clearCompletedTasks() {
        $(By.xpath(".//footer/button")).click();
    }

    public void destroyTask(String N) {
        Actions action = new Actions(getWebDriver());
        WebElement element = $(By.xpath(".//li[" + N + "]/div[@class='view']"));
        action.moveToElement(element)
                .moveToElement($(By.xpath(".//li[" + N + "]/div[@class='view']/button")))
                .click().build().perform();
    }

    public void destroyLastTask(String N) {
        Actions action = new Actions(getWebDriver());
        WebElement element = $(By.xpath(".//li[last()]/div[@class='view']"));
        action.moveToElement(element)
                .moveToElement($(By.xpath(".//li[last()]/div[@class='view']/button")))
                .click().build().perform();
    }

    public void checkActiveTasksCounterValue(String expectedValue) {
        Assert.assertEquals($(By.xpath(amountOfActiveTasks)).getText(), expectedValue,
                "checking active tasks counter value");
    }

    //---------------------------------ASSERTIONS----------------------------------

    public void assertThatNthElementHasText(String N, String text) {
        $(By.xpath(".//li[" + N + "]/div[@class='view']/label")).shouldHave(text(text));
    }

    public void assertThatListIsEmpty() {
        $(".view label").shouldNotBe(present);
    }

    public void assertThatListHasNElements(int N) {
        Assert.assertEquals(N, $$(".view label").size(), "checking amount elements on the list");
    }

    public void assertTaskStatus(String N, String expectedStatus) {
        Assert.assertEquals(expectedStatus,
                $(By.xpath(".//section[@class='main']/ul/li[" + N + "]")).getAttribute("class"), "checking task status");
    }

    public void assertAllTasksStatus(String expectedStatus) {
        for (int i = 0; i < totalAmountOfTasks; i ++) {
            String elementNo = String.valueOf(i + 1);
            assertTaskStatus(elementNo, expectedStatus);
        }
    }

    //--------------------------------HELPER METHODS--------------------------------

    public void selectAllText(WebElement textField) {
        textField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    }

    public void wait(int miliseconds) {
        getWebDriver().manage().timeouts().implicitlyWait(miliseconds, TimeUnit.MILLISECONDS);
    }

}