package dao;

import models.User;

import java.util.List;

public interface UserDao {

    //List all users
    List<User> getAll();

    //Create a user
    void add (User user);

    //Retrieve a single user
    User findById(int id);

    // UPDATE
    void update(int id, String name);

    // DELETE
    void deleteById(int id);
    void clearAllUsers();

}
