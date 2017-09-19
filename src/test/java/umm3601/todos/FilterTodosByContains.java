package umm3601.todos;

import org.junit.Test;
import umm3601.todo.Todo;
import umm3601.todo.TodoDatabase;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByContains {
  @Test
  public void getBanana() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] first = db.filterTodosByString(allTodos,"banana");
    assertEquals("Incorrect number of Todos that contain the string", 1, first.length);
  }

  @Test
  public void getStringA() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] second = db.filterTodosByString(allTodos,"Proident cupidatat exercitation id ullamco magna do qui aliquip id");
    assertEquals("Incorrect number of Todos that contain the string", 1, second.length);
  }

  @Test
  public void getStringB() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] second = db.filterTodosByString(allTodos,"occaecat");
    assertEquals("Incorrect number of Todos that contain the string", 78, second.length);
  }
}
