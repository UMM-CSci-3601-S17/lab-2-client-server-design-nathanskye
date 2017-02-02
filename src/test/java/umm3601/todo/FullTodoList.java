package umm3601.todo;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by benek020 on 2/1/17.
 */
public class FullTodoList {
    @Test
    public void listAllTodos() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        assertEquals("Incorrect total number of todos", 300, allTodos.length);
    }

    @Test
    public void firstTodoInFullList() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        Todo firstTodo = allTodos[0];
        assertEquals("Incorrect owner", "Blanche", firstTodo.owner);
        assertEquals("Incorrect status", false, firstTodo.status);
        assertEquals("Incorrect body", "In sunt ex non tempor cillum commodo amet incididunt anim qui commodo quis. Cillum non labore ex sint esse.", firstTodo.body);
        assertEquals("Incorrect category", "software design", firstTodo.category);
    }
}
