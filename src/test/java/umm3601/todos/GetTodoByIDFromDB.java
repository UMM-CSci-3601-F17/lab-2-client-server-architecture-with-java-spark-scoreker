package umm3601.todos;

import org.junit.Test;
import umm3601.todo.Todo;
import umm3601.todo.TodoDatabase;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class GetTodoByIDFromDB {

  @Test
  public void getBlanche() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo first = db.getTodo("58895985a22c04e761776d54");
    assertEquals("Incorrect owner", "Blanche", first.getOwner());
  }

  @Test
  public void getFry() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo second = db.getTodo("58895985c1849992336c219b");
    assertEquals("Incorrect owner", "Fry", second.getOwner());
  }
}
