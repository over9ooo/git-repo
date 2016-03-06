package com.greycat;

import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CompleteAllTasksTest extends ConciseAPI {

    @BeforeClass
    public static void openBrowser() {
        open("http://todomvc.com/examples/troopjs_require/");
    }

    @Test
    public void completeAllTasksMethod() {

        addNewTodo("do something");
        addNewTodo("another task");
        addNewTodo("newest todo");

        completeAllTasks();
        assertAllTasksStatus("completed");

        showActiveTasks();
        $(".//li[1]/div[@class='view']/label").shouldNotBe(Condition.present);



    }


}
