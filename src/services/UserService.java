package services;

import models.User;
import repositories.CountryRepository;
import repositories.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;
    private static UserService userService;

    private UserService() {
        this.userRepository = new UserRepository();
    }

    public static UserService getInstance(){
        if(userService == null){
            userService = new UserService();
        }
        return userService;
    }

    void addUser(User user){
        userRepository.addUser(user);
    }

    User getUserByName(String name){
        return userRepository.getUserByName(name);
    }

    User getUserById(int id){
        return userRepository.getUserById(id);
    }

    List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    void updateUsername(int id, String newName){
        userRepository.updateUsername(id, newName);
    }

    void removeUser(int id){
        userRepository.removeUser(id);
    }
}
