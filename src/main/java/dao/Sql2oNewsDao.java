package dao;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

import static org.postgresql.jdbc2.EscapedFunctions.INSERT;

public class Sql2oNewsDao implements NewsDao {

    private final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o){
        this.sql2o = sql2o; //making the sql2o object available everywhere so we can call methods in it
    }

    @Override
    public void add(News news) {
        String sql = "INSERT INTO news (generalContent, departmentContent, departmentId, publishedAt) VALUES (:generalContent, :departmentContent, :departmentId, :publishedAt)";//raw sql
        try (Connection con = sql2o.open()) {//try to open a connection
            int id = (int) con.createQuery(sql, true)//make a new variable
                    .bind(news)//map my argument onto the query so we can use information from it
                    .executeUpdate()//run it all
                    .getKey(); //int id is now the row number
            news.setId(id);//update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!
        }
    }

    @Override
    public List<Department> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM departments") //raw sql
                    .executeAndFetch(Department.class); //fetch a list
        }
    }

    @Override
    public Department findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM departments WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Department.class); //fetch an individual item
        }
    }

    @Override
    public void update(int id, String newName){
        String sql = "UPDATE departments SET name = :name WHERE id=:id";
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
    public void clearAllDepartments() {
        String sql = "DELETE from departments";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }



}
