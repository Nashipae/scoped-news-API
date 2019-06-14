package dao;

import models.Department;
import models.User;

import java.util.List;

public interface DepartmentDao {

    //List all departments
    List<Department> getAll();

    //Create a department
    void add (Department department);

    //Retrieve a single department
    Department findById(int id);

    List<User> getAllUsersByDepartment(int departmentId);

    void updateEmployeeCount(int departmentid, int employeecount);

    // UPDATE
     void update(int id, String name);

    // DELETE
     void deleteById(int id);
     void clearAllDepartments();
}
