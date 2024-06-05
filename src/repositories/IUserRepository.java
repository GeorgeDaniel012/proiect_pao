package repositories;

import models.Country;
import models.User;

import java.util.List;

public interface IUserRepository {
    //create
    void addUser(User user);

    //read
    User getUserByName(String name);
    User getUserById(int id);
    List<User> getAllUsers();

    //update
    void updateUsername(int id, String newName);

    //delete
    void removeUser(int id);
}
