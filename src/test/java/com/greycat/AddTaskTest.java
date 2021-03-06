package com.greycat;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class AddTaskTest extends ConciseAPI {

    @Test
    public void createTask() {

        open("http://todomvc.com/examples/troopjs_require/");
        addNewTodo("new todo");
        addNewTodo("do something");

        assertThatNthElementHasText("2", "do something");
        assertAllTasksStatus("active");
        assertThatListHasNElements(2);

    }

    @AfterClass
    public void cleanUp() {
        completeAllTasks();
        clearCompletedTasks();
        wait(500);
    }

}