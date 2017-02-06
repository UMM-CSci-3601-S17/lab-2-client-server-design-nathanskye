package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lumine on 2/6/2017.
 */
public class SortTodos {

    @Test
    public void numberOfTodos() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] todoList = todoController.sortTodos("category", todoController.listTodos(new HashMap<>()));
        assertEquals("Number of todos in sorted list is not 300", 300, todoList.length);
    }

    @Test
    public void firstTodoCategory() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] todoList = todoController.sortTodos("category", todoController.listTodos(new HashMap<>()));
        assertEquals("First todo is not groceries", "groceries", todoList[0].category);
    }

    @Test
    public void lastTodoCategory() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] todoList = todoController.sortTodos("category", todoController.listTodos(new HashMap<>()));
        assertEquals("First todo is not video games", "video games", todoList[299].category);
    }
}
