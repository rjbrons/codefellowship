# Spring Basic Web App
Create a app that allows users to log in and enter basic profile information.  
Ultimately users will be able to log in and make posts on their account, and see other user's posts.


# Functionality

- The site should have a splash page at the root route (/) that contains basic information about the site, as well as a link to the “sign up” page.  
- An ApplicationUser should have a username, password ( hashed using BCrypt), firstName, lastName, dateOfBirth, bio, and any other fields you think are useful.
- The site should allow users to create an ApplicationUser on the “sign up” page.
- The site should have a page which allows viewing the data about a single ApplicationUser, at a route like /users/{id}.
- Upon logging in, users are taken to a /myprofile route that displays their information.
- User registration also logs users into the app automatically.

## Routes
`/` - Takes users to the home page where they have the option to sign up or log in.

`/signup` - This gives users a form to fill out and sign up for the site.

`/login` - This takes users to a page where they enter their username and password to log in.  Redirects to that users profile page.

`/users` - Lists all the users in the system.

`/user/{id}`  - Displays information about a specific user by their ID.

# How to Use

- open app in intelliJ
    - build App
    - run App
- command line
    - from root - `./gradlew bootRun`
    - from root (to run tests) - `./gradlew test`
    
Server will run on localhost:8080



