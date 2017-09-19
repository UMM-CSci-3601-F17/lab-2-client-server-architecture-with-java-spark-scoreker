package umm3601.todo;

public class Todo {
  String _id;
  String owner;
  Boolean status;
  String body;
  String category;

  // Returns the owner so that FilterTodoByIDFromDB tests will work properly
  public String getOwner() {
    return owner;
  }

}





