package dao;

import models.Department;
import models.User;

import java.util.List;

public interface UserDao {


    //Create a user
    void add (User user);

    //List all users
    List<User> getAll();

    //List users by department
    List<Department> getAllUsersForADepartment(int id);

    //Add user to department
    void addUserToDepartment(User user, Department department);

    //Retrieve a single user
    User findById(int id);

    // UPDATE
    void update(int id, String name);

    // DELETE
    void deleteById(int id);
    void clearAllUsers();

}
