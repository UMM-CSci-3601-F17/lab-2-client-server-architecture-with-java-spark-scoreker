// Why do we use the `var getAllUsers = function()` syntax
// for the first definition, and the named function syntax
// for the second definition?

/**
 * Function to get all the todos!
 */
function getAllTodos() {
  console.log("Getting all the todos.");

  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos", function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

/**
 * Function to get a single todo via an ID
 */
function getTodo() {
  console.log("Getting the specified todo.");

  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos/" +  document.getElementById("id").value, function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getTodosByStatus() {
  console.log("Getting todos based on given status");

  var HttpThingy = new HttpClient();
  HttpThingy.get("api/todos?status=" + document.getElementById("status").value, function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getTodosByLimit() {
  console.log("Getting a number of todos based on given limit");

  var HttpThingy = new HttpClient();
  HttpThingy.get("api/todos?limit=" + document.getElementById("limit").value, function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getTodosByContains() {
  console.log("Getting todos which contain given string");

  var HttpThingy = new HttpClient();
  HttpThingy.get("api/todos?contains=" + document.getElementById("contains").value, function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getTodosByCategory() {
  console.log("Getting todos in given category");

  var HttpThingy = new HttpClient();
  HttpThingy.get("api/todos?category=" + document.getElementById("category").value, function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getTodosByOwner() {
  console.log("Getting todos with given owner");

  var HttpThingy = new HttpClient();
  HttpThingy.get("api/todos?owner=" + document.getElementById("owner").value, function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

/**
 * Wrapper to make generating http requests easier. Should maybe be moved
 * somewhere else in the future!.
 *
 * Based on: http://stackoverflow.com/a/22076667
 * Now with more comments!
 */
function HttpClient() {
  // We'll take a URL string, and a callback function.
  this.get = function(aUrl, aCallback){
    var anHttpRequest = new XMLHttpRequest();

    // Set a callback to be called when the ready state of our request changes.
    anHttpRequest.onreadystatechange = function(){

      /**58895985a22c04e761776d54
       * Only call our 'aCallback' function if the ready state is 'DONE' and
       * the request status is 200 ('OK')
       *
       * See https://httpstatuses.com/ for HTTP status codes
       * See https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
       *  for XMLHttpRequest ready state documentation.
       *
       */
      if (anHttpRequest.readyState === 4 && anHttpRequest.status === 200)
        aCallback(anHttpRequest.responseText);
    };

    anHttpRequest.open("GET", aUrl, true);
    anHttpRequest.send(null);
  }
}
