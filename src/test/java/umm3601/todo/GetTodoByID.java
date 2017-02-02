package umm3601.todo;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class GetTodoByID {

    @Test
    public void getWorkman() throws IOException {
        TodoController todoController = new TodoController();
        Todo todo = todoController.getTodo("58895985e2df5ee807c2853e");
        assertEquals("Incorrect owner", "Workman", todo.owner);
    }

    @Test
    public void getFry() throws IOException {
        TodoController todoController = new TodoController();
        Todo todo = todoController.getTodo("58895985313a7b3a51ca2b40");
        assertEquals("Incorrect owner", "Fry", todo.owner);
    }
}