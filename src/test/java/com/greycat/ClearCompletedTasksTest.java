package com.greycat;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class ClearCompletedTasksTest extends ConciseAPI{

    @Test
    public void deleteCompletedTasks() {

        open("http://todomvc.com/examples/troopjs_require/");
        addNewTodo("task to be completed");
        addNewTodo("another task");
        addNewTodo("newest todo");
        addNewTodo("do something");

        completeTask("1");
        completeTask("3");
        clearCompletedTasks();

        assertThatListHasNElements(2);
        assertAllTasksStatus("active");

    }

    @AfterTest
    public void checkActiveTasksCounter() {

        checkActiveTasksCounterValue("2");

        completeAllTasks();
        clearCompletedTasks();
        wait(500);

    }

}