# Scoped News API
#### Scoped News API is an application package that enables creation of departments and staff within an organization.
#### By **Naomi Wariara**
## Description
The API enables a user to access news from within his department or in the organization in general. It gives info about users and profiles them within the organization. 
## Setup/Installation Requirements
* To access the API use the link: https://scoped-news-api.herokuapp.com/
* For it to work, the user should download and install Postman and use the GET and POST methods to test the routes.

## Postman Usage
###Post  methods
* Adding a new department - "/departments/new"
* Adding a new user - "/users/new"
* Adding a new user to a department - "/departments/:id/users/new"
* Post departmental news - "/departments/:departmentId/news/new"
* Post general news - "/generalnews/new"


### Get methods
* Get all departments: "/departments"
* Get single department: "/departments/:id"
* Get all users in a department: "/departments/:id/users"
* Get all users: "/users"
* Get details of a specific user: "/users/:id"
* Get all users in a department - "/users/:id/departments"
* Get all news - "/generalnews"
* Get departmental news - "/departments/:id/news"
* Get specific news - "/news/:id"
* Delete all departments - "/departmentsdeleteall"
* Delete a department - "/departments/:id/delete"
* Delete a user - "/users/:id/delete"
* Delete all users - "/usersdeleteall"




## Known Bugs
The API has no known bugs. However, in case any challenges are noted, they can be reported through the contacts shared below.
## Technologies Used
The scoped news API uses Spark, JUnit, Postman and Psql. 
## Support and contact details
In case you'd like to improve on the app you may reach me on nashipaedigital@gmail.com. You may also fork the project from my GitHub repository https://github.com/Nashipae/scoped-news-API.git.
 
### License
MIT.
Copyright (c) 2019 