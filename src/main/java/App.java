import com.google.gson.Gson;
import dao.DB;
import dao.Sql2oUserDao;
import dao.Sql2oNewsDao;
import exceptions.ApiException;
import models.Department;
import dao.Sql2oDepartmentDao;

import java.util.HashMap;
import java.util.Map;

import models.News;
import models.User;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4563;
        }

        setPort(port);

        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/scoped_news_api.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");


        Sql2oUserDao userDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Gson gson = new Gson();

       departmentDao = new Sql2oDepartmentDao(DB.sql2o);
       userDao = new Sql2oUserDao(DB.sql2o);
       newsDao = new Sql2oNewsDao(DB.sql2o);


        //get: show all departments
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        //add a department
        post("/departments/new", "application/json", (req, res) -> {//accept a request in format JSON from an app
            Department department = gson.fromJson(req.body(), Department.class);//make java from JSON with GSON
            departmentDao.add(department);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department);
        });

        //list all departments
        get("/departments", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(departmentDao.getAll());//send it back to be displayed
        });

//        display details of a specific department
        get("/departments/:id","application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("id"));
            return gson.toJson(departmentDao.findById(departmentId));
        });


        get("/departments/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("id"));
            Department departmentToFind = departmentDao.findById(departmentId);
            return gson.toJson(departmentDao.findById(departmentId));
        });


        //show users from a specific department
        get("/departments/:id/users", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            Department departmentToFind = departmentDao.findById(departmentId);
            if (departmentToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }
            else if (userDao.getAllUsersForADepartment(departmentId).size()==0){
                return "{\"message\":\"I'm sorry, but no users are listed for this department.\"}";
            }
            else {
                return gson.toJson(userDao.getAllUsersForADepartment(departmentId));
            }
        });


        //add a new user to a department
        post("/departments/:id/users/new","application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("id"));
            User newUser = gson.fromJson(request.body(), User.class);
            newUser.setDepartmentId(departmentId);
            userDao.add(newUser);
            response.status(201);
            return gson.toJson(newUser);
        });

        get("/departments/:id/users","application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("id"));
            return gson.toJson(userDao.getAllUsersForADepartment(departmentId));
        });


        // add a new user
        post("/users/new", "application/json", (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
            userDao.add(user);
            res.status(201);
            res.type("application/json");
            return gson.toJson(user);
        });

        //show a list of all users
        get("/users", "application/json", (req, res) -> {
            if(userDao.getAll().size()>0){
                return gson.toJson(userDao.getAll());
            }else{
                return "{\"message\":\"Sorry, there are no users listed for now.\"}";
            }
        });

        post("/departments/:departmentId/user/:userId", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("departmentId"));
            int userId = Integer.parseInt(req.params("userId"));
            Department department = departmentDao.findById(departmentId);
            User user = userDao.findById(userId);
            if (department != null && user != null){
                //both exist and can be associated
                userDao.addUserToDepartment(user, department);
                res.status(201);
                return gson.toJson(String.format("User '%s' and Department '%s' have been associated",user.getStaffName(), department.getName()));
            }
            else {
                throw new ApiException(404, String.format("Department or User does not exist"));
            }
        });


        //get all users in a department
        get("/users/:id/departments", "application/json", (req, res) -> {
            int userId = Integer.parseInt(req.params("id"));
            User userToFind = userDao.findById(userId);
            if (userToFind == null){
                throw new ApiException(404, String.format("No user with the id: \"%s\" exists", req.params("id")));
            }
            else if (userDao.getAllUsersForADepartment(userId).size()==0){
                return "{\"message\":\"I'm sorry, but no departments are listed for this user.\"}";
            }
            else {
                return gson.toJson(userDao.getAllUsersForADepartment(userId));
            }
        });



        post("/departments/:departmentId/news/new", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("departmentId"));
            News news = gson.fromJson(req.body(), News.class);
            news.setDepartmentId(departmentId);
            newsDao.add(news);
            res.status(201);
            return gson.toJson(news);
        });

        //get all news
        get("/generalnews","application/json", (request, response) -> gson.toJson(newsDao.getAll()));

        post("/generalnews/new","application/json", (request, response) -> {
            News news=gson.fromJson(request.body(), News.class);
            newsDao.add(news);
            response.status(201);
            return  gson.toJson(news);
        });

        //get departmental news
        get("/departments/:id/news","application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("id"));
            return gson.toJson(newsDao.getAllNewssByDepartment(departmentId));
        });

        get("/news/:id","application/json", (request, response) -> {
            int newsId = Integer.parseInt(request.params("id"));
            return gson.toJson(newsDao.findById(newsId));
        });

        post("/departments/:id/news/new","application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("id"));
            String content = request.params("content");
            News newNews = gson.fromJson(request.body(), News.class);
            newNews.setDepartmentId(departmentId);
            newsDao.add(newNews);
            response.status(201);
            return gson.toJson(newNews);
        });

        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = (ApiException) exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
//            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });
//

    }

}




