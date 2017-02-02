Q: What is the purpose of .gitignore?
A: Excludes certain files and file types from github commits and pushes. 
Specifically node modules, stuff specific to intellijIDEA, and gradle.

Q: Explain what a Route is.
A: "The main building block of a Spark application is a set of routes. A route is made up of three simple pieces:
    
    A verb (get, post, put, delete, head, trace, connect, options)
    A path (/hello, /users/:name)
    A callback (request, response) -> { }
    Routes are matched in the order they are defined. The first route that matches the request is invoked."
    
In other words, the user types a URL and Spark interprets it based on some specified behavior server-side.
For example, if a user requests a "/" URL we could write a get function that returns a String for that page.

Q: What is the purpose of umm3601.Server class? 
A: To define all the routes for redirecting the client and to wrap data in JSON.

Q: What is the purpose of the umm3601.user.UserController class? 
A: Provides an interface to access user data by allowing filtering, listing of users, and the ability 
to retrieve specific users by ID.

Q; Explain what happens when a user accesses each of the following URLs:
A: users: redirects to /users.html
api/users: dumps contents of users.json 
api/users?age=25: Displays all users that have an "age" field with a value of 25
api/users/588935f5de613130e931ffd5: Displays the user with "_id" field of 588935f5de613130e931ffd5 
which is Valerie Erickson

Q: What happens when the user accesses the page "kittens"? Modify the server code so accessing 
the page "kittens" results in the text "Meow". Describe what you did and how it worked.
A: "This site can't be reached" because that page doesn't exist. 
To make it say "meow" we wrote:

    get("/kittens", (req, res) -> {
        return "meow";
    });
    
in Server.java. This is a Route that makes it so that when /kittens is requested the String "meow"
is returned and displayed on the web page.

Q: What are the contents of the public folder? What is the purpose of each of the HTML files there?
A: The file structure is:

  public
    assets.images
        puppies.jpg
    css
        main.css
    javascript
        users.js
    about.html - This is an "about" page! is displayed along with a small navigation bar 
    index.html - Shows a small nav bar with elements "ABOUT KITTENS Add a new pet! Users", has a picture
                 of some adorable sleeping puppies along with a button "Send an alert!" with no functionality!
    users.html - Displays a webpage with a button that lists all of the users in raw json format
    
    
Q: Describe what happens when you filter users by age in the client? What is read from the web page, and what request 
   is sent to the server? What is received, and how/where is it displayed?
A: When the client requests a page such as /api/users?age=25 Spark sees the question mark after
   "users" and knows that an argument is being provided as a request to filter user data. 
   The argument "age=25" is read by the server which gives it the information necessary for filtering the user list. 
   Filtering happens by creating a QueryMap that contains the arguments sent through in the URL. This argument QueryMap 
   is read by the method listUsers(Map<String, String[]> queryParams) which recognizes the "age" identifier, extracts
   the value of 25 and uses the filterByAge(User[] filteredUsers, int age) to filter the user list by
   the age value of 25. The resulting list is received by the client in a json format and displayed on the web page
   in raw json format.
   
Q: Where is the client-side JavaScript defined? Name the file(s) in which it is used.
A: The client-side javascript is composed of one file: src/main/resources/public/javascript/users.js
   The only usage found for the users.js file is within users.html. 