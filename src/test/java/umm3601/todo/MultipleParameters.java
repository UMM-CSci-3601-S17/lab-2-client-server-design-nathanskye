package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lumine on 2/6/2017.
 */
public class MultipleParameters {

    @Test
    public void testOwnerStatusLimitBlanche() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        String[] blanche = {"Blanche"};
        String[] complete = {"complete"};
        String[] limit = {"12"};
        queryParams.put("owner", blanche);
        queryParams.put("status", complete);
        queryParams.put("limit", limit);

        Todo[] todoList = todoController.listTodos(queryParams);
        assertEquals("owner is not Blanche", "Blanche", todoList[0].owner);
        assertEquals("status is not complete", true, todoList[0].status);
        assertEquals("limit is not 12", 12, todoList.length);
    }

    @Test
    public void testOwnerStatusLimitFry() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        String[] fry = {"Fry"};
        String[] incomplete = {"incomplete"};
        String[] limit = {"200"};
        String[] contains = {"Ipsum"};
        queryParams.put("owner", fry);
        queryParams.put("status", incomplete);
        queryParams.put("limit", limit);
        queryParams.put("contains", contains);

        Todo[] todoList = todoController.listTodos(queryParams);
        assertEquals("owner is not Fry", "Fry", todoList[0].owner);
        assertEquals("status is not incomplete", false, todoList[0].status);
        assertEquals("limit is not 1", 1, todoList.length);
        assertEquals("does not contain Ipsum", "Ipsum esse est ullamco magna tempor anim laborum non officia deserunt veniam commodo. Aute minim incididunt ex commodo.", todoList[0].body);
    }
}
