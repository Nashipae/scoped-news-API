package dao;

import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

import static org.postgresql.jdbc2.EscapedFunctions.INSERT;

public class Sql2oUsersDao implements UsersDao {

    private final Sql2o sql2o;

    public Sql2oUsersDao(Sql2o sql2o){
        this.sql2o = sql2o; //making the sql2o object available everywhere so we can call methods in it
    }

    @Override
    public void add() {
        String sql = "INSERT INTO users (id, staffName, staffRole, staffPosition, departmentId) VALUES (:id, staffName, staffRole, staffPosition, departmentId)";//raw sql
        try (Connection con = sql2o.open()) {//try to open a connection
            int id = (int) con.createQuery(sql, true)//make a new variable
                    .bind(users)//map my argument onto the query so we can use information from it
                    .executeUpdate()//run it all
                    .getKey(); //int id is now the row number
            news.setId(id);//update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!
        }
    }

    @Override
    public List<News> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM news") //raw sql
                    .executeAndFetch(News.class); //fetch a list
        }
    }

    @Override
    public List<News> getAllNewssByDepartment(int departmentId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news WHERE departmentId = :departmentId")
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public News findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM news WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(News.class); //fetch an individual item
        }
    }

    @Override
    public void update(int id, String newName){
        String sql = "UPDATE news SET name = :name WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", newName)
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
    public void clearAllNewss() {
        String sql = "DELETE from news";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }



}
