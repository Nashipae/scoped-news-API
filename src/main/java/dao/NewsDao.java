package dao;

import models.News;
import java.util.List;

public interface NewsDao {

    //List all newss
    List<News> getAll();

    //List news by department
    List<News> getAllNewssByDepartment(int departmentId);

    //Create a news
    void add (News news);

    //Retrieve a single news
    News findById(int id);

    // UPDATE
    void update(int id, String name);

    // DELETE
    void deleteById(int id);
    void clearAllNewss();
}
