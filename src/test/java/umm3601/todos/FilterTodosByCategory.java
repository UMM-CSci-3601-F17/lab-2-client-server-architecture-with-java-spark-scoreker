package umm3601.todos;

import org.junit.Test;
import umm3601.todo.Todo;
import umm3601.todo.TodoDatabase;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByCategory {
  @Test
  public void getSoftware_Design() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] first = db.filterTodosByCategory(allTodos, "software design");
    assertEquals("Incorrect number of Todos that are in the software design category", 74, first.length);
  }

  @Test
  public void getVideo_Game() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] first = db.filterTodosByCategory(allTodos, "video games");
    assertEquals("Incorrect number of Todos that are in the video game category", 71, first.length);
  }

  @Test
  public void getHomework() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] first = db.filterTodosByCategory(allTodos, "homework");
    assertEquals("Incorrect number of Todos that are in the homework", 79, first.length);
  }

  @Test
  public void getGroceries() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] first = db.filterTodosByCategory(allTodos, "groceries");
    assertEquals("Incorrect number of Todos that are in the grocery category", 76, first.length);
  }
}
