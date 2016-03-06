package com.greycat;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class CompleteTaskTest extends ConciseAPI{

    @BeforeClass
    public static void openBrowser() {
        open("http://todomvc.com/examples/troopjs_require/");
    }

    @Test
    public void completeTask() {

        addNewTodo("task to be completed");
        addNewTodo("another task");
        addNewTodo("newest todo");

        completeTask("1");
        completeTask("3");

        assertTaskStatus("1", "completed");
        assertTaskStatus("2", "active");
        assertTaskStatus("3", "completed");
        assertThatListHasNElements(3);

    }

    @AfterTest
    public void cleanUp() {
        completeAllTasks();
        clearCompletedTasks();
    }

}