package umm3601.todo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by benek020 on 2/1/17.
 */
public class TodoController {
    private Todo[] todos;

    public TodoController() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("src/main/data/todos.json");
        todos = gson.fromJson(reader, Todo[].class);
    }

    // List todos
    public Todo[] listTodos(Map<String, String[]> queryParams) {
        Todo[] filteredTodos = todos;

//        // Filter age if defined
//        if(queryParams.containsKey("age")) {
//            int age = Integer.parseInt(queryParams.get("age")[0]);
//            filteredTodos = filterTodosByAge(filteredTodos, age);
//        }

        return filteredTodos;
    }
//
//    // Filter todos by age
//    public Todo[] filterTodosByAge(Todo[] filteredTodos, int age) {
//        return Arrays.stream(filteredTodos).filter(x -> x.age == age).toArray(Todo[]::new);
//    }
//
//    // Get a single todo
//    public Todo getTodo(String id) {
//        return Arrays.stream(todos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
// }

}

