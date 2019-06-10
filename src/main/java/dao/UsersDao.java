package dao;

import models.Users;

import java.util.List;

public interface UsersDao {

    //List all users
    List<Users> getAll();

    //Create a user
    void add (Users users);

    //Retrieve a single user
    Users findById(int id);

    // UPDATE
    void update(int id, String name);

    // DELETE
    void deleteById(int id);
    void clearAllUsers();

}
