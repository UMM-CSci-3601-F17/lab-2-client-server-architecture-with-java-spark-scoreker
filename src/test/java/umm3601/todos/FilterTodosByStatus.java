package umm3601.todos;

import org.junit.Test;
import umm3601.todo.Todo;
import umm3601.todo.TodoDatabase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByStatus {

  @Test
  public void filterTodosByStatus() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] statusComplete = db.filterTodosByStatus(allTodos, true);
    assertEquals("Incorrect number of Todos that are completed", 143, statusComplete.length);

    Todo[] statusIncomplete = db.filterTodosByStatus(allTodos, false);
    assertEquals("Incorrect number of Todos that are incompleted", 157, statusIncomplete.length);
  }

}



