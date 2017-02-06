package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Lumine on 2/6/2017.
 */
public class FilterContains {

    @Test
    public void containsNisi() throws IOException{
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        String[] value = {"nisi"};
        queryParams.put("contains", value);
        Todo[] todoList = todoController.listTodos(queryParams);
        assertEquals("Number of todos with nisi is not 77", 77, todoList.length);
    }

    @Test
    public void containsBanana() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        String[] value = {"banana"};
        queryParams.put("contains", value);
        Todo[] todoList = todoController.listTodos(queryParams);
        assertEquals("Number of todos with banana is not 0", 0, todoList.length);
    }

}
