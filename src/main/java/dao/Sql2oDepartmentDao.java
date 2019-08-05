package dao;

import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import models.Department;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {

    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o){
        this.sql2o = sql2o; //making the sql2o object available everywhere so we can call methods in it
    }

    @Override
    public void add(Department department) {
        String sql = "INSERT INTO departments (name, description) VALUES (:name, :description)";//raw sql
        try (Connection con = DB.sql2o.open()) {//try to open a connection
            int id = (int) con.createQuery(sql, true)//make a new variable
                    .bind(department)//map my argument onto the query so we can use information from it
                    .executeUpdate()//run it all
                    .getKey(); //int id is now the row number
            department.setId(id);//update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void addDepartmentToUser(Department department, User user){
        String sql = "INSERT INTO departmentUsers (departmentid, usersid) VALUES (:departmentId, :userId)";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("departmentId", department.getId())
                    .addParameter("userId", user.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


    @Override
    public List<Department> getAll() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM departments") //raw sql
                    .executeAndFetch(Department.class); //fetch a list
        }
    }

    @Override
    public Department findById(int id){
        String sql = "SELECT * FROM departments WHERE id = :id;";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Department.class);
        }
    }
    @Override
    public List<User> getAllUsersByDepartment(int departmentId) {
        List<User> users = new ArrayList<>();

        String joinQuery = "SELECT userid FROM departmentUsers WHERE departmentid = :departmentId";

        try (Connection con = sql2o.open()) {
            List<Integer> allUsersIds = con.createQuery(joinQuery)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(Integer.class);
            for (Integer userId : allUsersIds){
                String userQuery = "SELECT * FROM users WHERE id = :userId";
                users.add(
                        con.createQuery(userQuery)
                                .addParameter("userId", userId)
                                .executeAndFetchFirst(User.class));
            }
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
        return users;
    }

    @Override
    public void update(int id, String name, String description){
        String sql = "UPDATE departments SET name = :name, description = :description WHERE id = :id;";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("description", description)
                    .addParameter("name", name)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from departments WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllDepartments() {
        String sql = "DELETE from departments";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


    @Override
    public void updateEmployeeCount(int id, int employeeCount){

        String sql="UPDATE departments SET employeeCount = :employeeCount WHERE id=:id;";

        try(Connection con=sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("employeeCount",employeeCount)
                    .executeUpdate();
        }
    }

}
