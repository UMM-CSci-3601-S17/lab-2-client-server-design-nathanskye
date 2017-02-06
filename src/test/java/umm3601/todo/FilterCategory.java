package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lumine on 2/6/2017.
 */
public class FilterCategory {

    @Test
    public void numberOfSoftwareDesign() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        String[] value = {"software design"};
        queryParams.put("category", value);
        Todo[] todoList = todoController.listTodos(queryParams);
        assertEquals("Number of todos with category \"software design\" is not 74", 74, todoList.length);
    }

    @Test
    public void numberOfVideoGames() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        String[] value = {"video games"};
        queryParams.put("category", value);
        Todo[] todoList = todoController.listTodos(queryParams);
        assertEquals("Number of todos with category \"video games\" is not 71", 71, todoList.length);
    }
}
