package umm3601.todo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

        // Filters todos by status
        if (queryParams.containsKey("status")) {
            filteredTodos = filterStatus(queryParams.get("status")[0], filteredTodos);
        }

        if (queryParams.containsKey("contains")){
            filteredTodos = filterContains(queryParams.get("contains")[0], filteredTodos);
        }

        return filteredTodos;
    }

    // Filters a given array of Todos by their status.
    // Takes a String Status, either "complete" or "incomplete" and a Todo[].
    // Returns a Todo[]
    public Todo[] filterStatus(String Status, Todo[] filteredTodos){
        boolean status = Status.equals("complete");

        int size = 0;

        for (int i = 0; i < filteredTodos.length; i++){
            if (filteredTodos[i].status == status){
                size++;
            }
        }

        Todo[] statusTodos = new Todo[size];
        size = 0;

        for (int i = 0; i < todos.length; i++){
            if (filteredTodos[i].status == status){
                statusTodos[size] = filteredTodos[i];
                size++;
            }
        }

        return statusTodos;
    }

    //Filters a Todo[] to contain only a given word
    //Takes a string to search for, and a Todo[] to search in
    //Returns a Todo[]
    public Todo[] filterContains(String filter, Todo[] filteredTodos){
        int size = 0;

        for (Todo todo : filteredTodos){
            String body = todo.body;
            if (body.contains(filter))
                size++;
        }

        Todo[] containTodos = new Todo[size];
        size = 0;

        for (Todo todo : filteredTodos){
            if (todo.body.contains(filter))
                containTodos[size++] = todo;
        }

        return containTodos;
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

