package umm3601.todos;

import org.junit.Test;
import umm3601.todo.Todo;
import umm3601.todo.TodoDatabase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class GetTodoListLimitedByInt {

  // Tests limit the todo data and ensures that only X amount of JSON objects exist

  @Test
  public void getTodoListLimitedByFive() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] limitOfFive = db.filterTodosByLimit(allTodos, 5);
    assertEquals("Incorrect number of Todos in the list", 5, limitOfFive.length);
  }

  @Test
  public void getTodoListLimitedByOneHundred() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] limitOfOneHundred = db.filterTodosByLimit(allTodos, 100);
    assertEquals("Incorrect number of Todos in the list", 100, limitOfOneHundred.length);
  }
}
