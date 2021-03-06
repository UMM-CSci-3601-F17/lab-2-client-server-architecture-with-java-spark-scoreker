package umm3601.todo;

/*
Sam Score
Nick Plucker
 */

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * A fake "database" of todo info
 *
 * Since we don't want to complicate this lab with a real database,
 * we're going to instead just read a bunch of todo data from a
 * specified JSON file, and then provide various database-like
 * methods that allow the `TodoController` to "query" the "database".
 */
public class TodoDatabase {
  private Todo[] allTodos;

  public TodoDatabase(String todoDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(todoDataFile);
    allTodos = gson.fromJson(reader, Todo[].class);
  }

  /**
   * Get the single todo specified by the given ID. Return
   * `null` if there is no todo with that ID.
   *
   * @param id the ID of the desired todos
   * @return the todo with the given ID, or null if there is no todo
   * with that ID
   */
  public Todo getTodo(String id) {
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

  /**
   * Get an array of all the todos satisfying the queries in the params.
   *
   * @param queryParams map of required key-value pairs for the query
   * @return an array of all the todos matching the given criteria
   */
  public Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodos = allTodos;

    // Filter status if defined
    if(queryParams.containsKey("status")) {
      String status = queryParams.get("status")[0];
      if(status.equals("complete")) {
        boolean targetStatus = true;
        filteredTodos = filterTodosByStatus(filteredTodos, targetStatus);
      }
      if(status.equals("incomplete")) {
        boolean targetStatus = false;
        filteredTodos = filterTodosByStatus(filteredTodos, targetStatus);
      }
    }
    // Filter by string if defined
    if(queryParams.containsKey("contains")) {
      String targetString = queryParams.get("contains")[0];
      filteredTodos = filterTodosByString(filteredTodos, targetString);
    }

    // Filter by a limit if defined
    if(queryParams.containsKey("limit")) {
      int targetLimit = Integer.parseInt(queryParams.get("limit")[0]);
      filteredTodos = filterTodosByLimit(filteredTodos, targetLimit);
    }

    // Filter by a category if defined
    if(queryParams.containsKey("category")) {
      String targetString = queryParams.get("category")[0];
      filteredTodos = filterTodosByCategory(filteredTodos, targetString);
    }

    // Filter by a owner if defined
    if(queryParams.containsKey("owner")) {
      String targetString = queryParams.get("owner")[0];
      filteredTodos = filterTodosByOwner(filteredTodos, targetString);
    }


    return filteredTodos;
  }

  /**
   * Get an array of all the todos having the target status.
   *
   * @param todos the list of todos to filter by status
   * @param targetStatus the target status to look for
   * @return an array of all the todos from the given list that have
   * the target status
   */
  public Todo[] filterTodosByStatus(Todo[] todos, boolean targetStatus) {
    return Arrays.stream(todos).filter(x -> x.status == targetStatus).toArray(Todo[]::new);
  }

  /**
   * Get an array of all the todos having the target limit.
   *
   * @param todos the list of todos to filter by status
   * @param targetLimit the target limit to look for
   * @return an array of all the todos from the given list that have
   * the target limit
   */
  public Todo[] filterTodosByLimit(Todo[] todos, int targetLimit) {
    Todo[] todoHolder = new Todo[targetLimit];
    for(int i = 0; i < targetLimit; i++) {
      todoHolder[i] = todos[i];
    }
    return todoHolder;
  }

  /**
   * Get an array of all the todos having the target string (contains).
   *
   * @param todos the list of todos to filter by status
   * @param targetString the target string to look for
   * @return an array of all the todos from the given list that have
   * the target string
   */
  public Todo[] filterTodosByString(Todo[] todos, String targetString) {
    return Arrays.stream(todos).filter(x -> x.body.contains(targetString)).toArray(Todo[]::new);
  }

  /**
   * Get an array of all the todos having the target category.
   *
   * @param todos the list of todos to filter by category
   * @param targetCategory the target category to look for
   * @return an array of all the todos from the given list that have
   * the target category
   */
  public Todo[] filterTodosByCategory(Todo[] todos, String targetCategory) {
    return Arrays.stream(todos).filter(x -> x.category.contains(targetCategory)).toArray(Todo[]::new);
  }

  /**
   * Get an array of all the todos having the target owner.
   *
   * @param todos the list of todos to filter by owner
   * @param targetOwner the target owner to look for
   * @return an array of all the todos from the given list that have
   * the target owner
   */
  public Todo[] filterTodosByOwner(Todo[] todos, String targetOwner) {
    return Arrays.stream(todos).filter(x -> x.owner.contains(targetOwner)).toArray(Todo[]::new);
  }
}
