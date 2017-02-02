package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by benek020 on 2/1/17.
 */
public class GetMaxTodos {

    @Test
    public void testLimit5() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        String[] value = {"5"};
        queryParams.put("limit", value);
        Todo[] fiveTodos = todoController.listTodos(queryParams);
        assertTrue("total number of todos is greater than 5", fiveTodos.length <= 5);

    }

    @Test
    public void testLimit301() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        String[] value = {"301"};
        queryParams.put("limit", value);
        Todo[] lotsOfTodos = todoController.listTodos(queryParams);
        assertEquals("total number of todos is greater than 300", 300, lotsOfTodos.length);
    }
}