package com.greycat;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class DeleteTaskTest extends ConciseAPI{

    @Test
    public void deleteTask() {

        open("http://todomvc.com/examples/troopjs_require/");
        addNewTodo("new todo task");
        destroyTask("1");

        assertThatListIsEmpty();

    }

}
