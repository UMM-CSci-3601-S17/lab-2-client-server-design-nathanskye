package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lumine on 2/6/2017.
 */
public class FilterOwner {

        @Test
        public void numberOfBlanche() throws IOException {
            TodoController todoController = new TodoController();
            Map<String, String[]> queryParams = new HashMap<>();
            String[] value = {"Blanche"};
            queryParams.put("owner", value);
            Todo[] todoList = todoController.listTodos(queryParams);
            assertEquals("Number of todos with owner Blanche is not 43", 43, todoList.length);
        }

        @Test
        public void numberOfFry() throws IOException {
            TodoController todoController = new TodoController();
            Map<String, String[]> queryParams = new HashMap<>();
            String[] value = {"Fry"};
            queryParams.put("owner", value);
            Todo[] todoList = todoController.listTodos(queryParams);
            assertEquals("Number of todos with owner Fry is not 61", 61, todoList.length);
        }
}
