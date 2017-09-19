package umm3601.todos;

import org.junit.Test;
import umm3601.todo.Todo;
import umm3601.todo.TodoDatabase;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class GetTodosByOwner {
  @Test
  public void getBlanche() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] first = db.filterTodosByOwner(allTodos,"Blanche");
    assertEquals("Incorrect number of Todos that Blanche owns", 43, first.length);
  }

  @Test
  public void getFry() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] second = db.filterTodosByOwner(allTodos,"Fry");
    assertEquals("Incorrect number of Todos that Fry owns", 61, second.length);
  }

  @Test
  public void getBarry() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] third = db.filterTodosByOwner(allTodos,"Barry");
    assertEquals("Incorrect number of Todos that Barry owns", 51, third.length);
  }

  @Test
  public void getWorkman() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] fourth = db.filterTodosByOwner(allTodos,"Workman");
    assertEquals("Incorrect number of Todos that Workman owns", 49, fourth.length);
  }

  @Test
  public void getDawn() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] fifth = db.filterTodosByOwner(allTodos,"Dawn");
    assertEquals("Incorrect number of Todos that Dawn owns", 50, fifth.length);
  }

  @Test
  public void getRoberta() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] sixth = db.filterTodosByOwner(allTodos,"Roberta");
    assertEquals("Incorrect number of Todos that Roberta owns", 46, sixth.length);
  }
}
