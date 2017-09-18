# 1. What is the purpose of .gitignore?
 It allows developers to specify certain files to ignore and not be committed to the  	 repository. 
# 2. Explain what a route is.
A route is an addition onto the base url that is used to send users to different pages.

# 3. What is the purpose of umm3601.Server class? What is the purpose of the umm3601.user.UserController class? Explain what happens when a user accesses each of the following URLs:
- The page users
- The page api/users
- The page api/users?age=25
- The page api/users/588935f5de613130e931ffd5

The server class creates the pages and gets data from the database. The UserController class gets the JSON response from the “database”. The page users allows a user to access info of other users either by age or by a list of all users. The page api/users is a list of every single user in a JSON format. The page api/users?age=25 is a list of all 25 year old users in a JSON format. The page api/users/588935f5de613130e931ffd5 gets a single user by their user id in a JSON format.

# 4. What are the contents of the public folder? What is the purpose of each of the HTML files there?
The public folder contains a css folder with a main.css file. There is also a javascript folder that contains users.js. Also, there are three html files: about.html, users.html and index.html. The about.html file is just an about page. There is a link to go back to the home page and there is text that says “This is an “about” page!”. Users.html is the page for viewing the json data. The index.html file is a “home” page that directs you to the appropropriate pages. 

# 5. Describe what happens when you filter users by age in the client? What is read from the web page, and what request is sent to the server? What is received, and how/where is it displayed?
When you filter users by age in the client, a nasty looking JSON list appears with users who have the specified age. The thing that is read from the web page is the age entered and the request is getAllUsersByAge, as stated in users.html. A JSON list is received and it is displayed on the user’s web page. 

# 6. Where is the client-side JavaScript defined? Name the file(s) in which it is used.
The client-side JavaScript is defined in users.html and index.html. It’s also used in users.js. 

