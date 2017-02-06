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
public class FilterStatus {

    @Test
    public void numberOfComplete() throws IOException{
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        String[] value = {"complete"};
        queryParams.put("status", value);
        Todo[] todoList = todoController.listTodos(queryParams);
        assertEquals("Number of todos with complete is not 143", 143, todoList.length);
    }

    @Test
    public void numberOfIncomplete() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        String[] value = {"incomplete"};
        queryParams.put("status", value);
        Todo[] todoList = todoController.listTodos(queryParams);
        assertEquals("Number of todos with incomplete is not 157", 157, todoList.length);
    }

}
