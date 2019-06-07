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

        //get: delete all departments
        get("/departments/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            departmentDao.clearAllDepartments();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: delete an individual department
        get("/departments/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfDepartmentToDelete = Integer.parseInt(req.params("id"));
            departmentDao.deleteById(idOfDepartmentToDelete);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: show all departments
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Department> departments = departmentDao.getAll();
            model.put("departments", departments);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show new department form
        get("/departments/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "department-form.hbs");
        }, new HandlebarsTemplateEngine());

        //department: process new department form
        post("/departments", (req, res) -> { //URL to make new department on POST route
            Map<String, Object> model = new HashMap<>();
            String description = req.queryParams("description");
            Department newDepartment = new Department(description);
            departmentDao.add(newDepartment);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: show an individual department
        get("/departments/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfDepartmentToFind = Integer.parseInt(req.params("id"));
            Department foundDepartment = departmentDao.findById(idOfDepartmentToFind);
            model.put("department", foundDepartment);
            return new ModelAndView(model, "department-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a department
        get("/departments/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfDepartmentToEdit = Integer.parseInt(req.params("id"));
            Department editDepartment = departmentDao.findById(idOfDepartmentToEdit);
            model.put("editDepartment", editDepartment);
            return new ModelAndView(model, "department-form.hbs");
        }, new HandlebarsTemplateEngine());

        //department: process a form to update a department
        post("/departments/:id", (req, res) -> { //URL to update department on POST route
            Map<String, Object> model = new HashMap<>();
            String newContent = req.queryParams("description");
            int idOfDepartmentToEdit = Integer.parseInt(req.params("id"));
            departmentDao.update(idOfDepartmentToEdit, newContent);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());
    }
}