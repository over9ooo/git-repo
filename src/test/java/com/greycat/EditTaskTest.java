package com.greycat;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class EditTaskTest extends ConciseAPI {

    @BeforeClass
    public static void openBrowser() {
        open("http://todomvc.com/examples/troopjs_require/");
    }

    @Test
    public void editSomeTasks() {

        addNewTodo("task to be completed");
        addNewTodo("another task");
        addNewTodo("newest todo");

        completeTask("1");
        editTask("1", "completed task edited");
        editTask("2", "active task edited");

        assertThatNthElementHasText("1", "completed task edited");
        assertThatNthElementHasText("2", "active task edited");

    }

    @AfterTest
    public void cleanUp() {
        completeAllTasks();
        clearCompletedTasks();
    }

}
