import com.google.gson.Gson;
import models.Department;
import dao.Sql2oDepartmentDao;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/todolist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oDepartmentDao departmentDao = new Sql2oDepartmentDao(sql2o);
        Gson gson = new Gson();


        //get: show all departments
//        get("/", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            List<Department> departments = departmentDao.getAll();
//            model.put("departments", departments);
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());

        post("/departments/new", "application/json", (req, res) -> {//accept a request in format JSON from an app
            Department department = gson.fromJson(req.body(), Department.class);//make java from JSON with GSON
            departmentDao.add(department);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department);
        });

        get("/departments", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(departmentDao.getAll());//send it back to be displayed
        });

        get("/departments/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(departmentDao.findById(departmentId));
        });
    }


}
