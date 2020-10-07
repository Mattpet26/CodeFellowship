# CodeFellowship

## Routes
"/": This is the home route. All users have permission to access the route. This route has a nav bar to help aid the user navigate the website
"/login": This route has fields for the user to enter information. If the information is correct, they will be redirected to "/"
"/signup": This route has fields for the user to enter. Once the information is entered and the user hits submit, they will be directed to login
"/user/{username}": This route shows the individual user data. Users can look up other users and follow them.
"/feed": This route will allow users to see posts about other users that they are following.

## How to use the app
- First clone down the repo
```
git clone https://github.com/Mattpet26/CodeFellowship.git
```
- Users can go to src/main/java/com.petersen.CodeFellowship/models and hit play

- Now go to the web and utilize the localhost and create a user
```
localhost:8080 (home page)
```
- After a user is created, the user can view their page or other users pages
```
|| localhost:8080/user/(username)
```
- Each user is able to make posts on their page
- A user MUST be logged in to view other users pages

## TaskList
- [x] The site should have a splash page at ("/").
- [x] The application user should have a constructor with appropriate keys.
- [x] The site should allow users to create or sign up with new users.
- [x] The users should be able to view data about a single user at /users/{id}.
- [x] When a user is logged in, each page should display the username.
- [x] The site should have a personalized error page.
- [x] Add a post entitiy to the app.
    - [x] The post has a body and timestamp.
    - [x] Posts are unique and tied to an individual user.
    - [x] Posts are visible on the profile page.
- [] Users should be taken to their profile when they log in.
- [x] Login/signup/home should all be available to a user that isn't logged in.
- [] Allow users to follow other users
- [] A user can visit a /feed to view all posts from users they follow
    - [] Each post should have a link to the user who wrote the post
