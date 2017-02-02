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

        // Retrieves a maximum, max, number of todos
        if(queryParams.containsKey("limit")) {
            int max = Integer.parseInt(queryParams.get("limit")[0]);

            // Allow maximum number of entries
            if(max > 300)
                max = 300;

            filteredTodos = new Todo[max];

            for (int i = 0; i < max; i++){
                filteredTodos[i] = todos[i];
            }
        }

        return filteredTodos;
    }
//
//    // Filter todos by age
//    public Todo[] filterTodosByAge(Todo[] filteredTodos, int age) {
//        return Arrays.stream(filteredTodos).filter(x -> x.age == age).toArray(Todo[]::new);
//    }
//
    // Get a single todo
    public Todo getTodo(String id) {
        return Arrays.stream(todos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
 }



}

