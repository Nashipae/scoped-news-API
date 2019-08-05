package dao;

import com.google.gson.JsonElement;
import models.Department;
import models.User;

import java.util.List;

public interface DepartmentDao {

    //List all departments
    List <Department> getAll();

    //Create a department
    void add (Department department);
    void addDepartmentToUser(Department department, User user);

    //Retrieve a single department
    Department findById(int id);

    List<User> getAllUsersByDepartment(int departmentId);

    void updateEmployeeCount(int departmentId, int employeeCount);

    // UPDATE
     void update(int id, String name, String description);

    // DELETE
     void deleteById(int id);
     void clearAllDepartments();
}
